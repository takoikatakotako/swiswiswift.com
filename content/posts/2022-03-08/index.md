+++
title =  "API GatewayとLambdaとDynamoDBを組み合わせてToDoアプリを作る"
url = "2022-03-08"
date = "2022-03-08"
description = "API GatewayとLambdaとDynamoDBを組み合わせてToDoアプリを作る"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/03"
aliases = ["migrate-from-jekyl"]
+++

<br>

GatewayとLambdaとDynamoDBを組み合わせてToDoアプリを作る方法です。

Lambda 関数を作ります。
![Create Function](1.png)

API GatewayでRestAPIを作ります。
![Create RestAPI](2.png)

![Create RestAPI](3.png)

アクションから「リソースの作成」を選択します。

![Create Resorce](4.png)

![Create Resorce](5.png)

アクションから「メソッドの作成」を選択します。

![Create Method](6.png)

Getを選択し、先ほど作成したLambda関数と連携させます。

![Create Method](7.png)

アクションから「APIのデプロイ」を選択します。

![API Deploy](8.png)

デプロイ先のステージを選択します。ステージがない場合は新しいステージを作成します。

![Create Stage](9.png)

![Create Stage](10.png)

作成されたステージ + メソッド名をブラウザに入力し、`"Hello from Lambda!"` と表示されることを確認します。
今回の場合は `https://eio7s05pk1.execute-api.ap-northeast-1.amazonaws.com/production/todo-app` となります。



次にDynamoDBを作ります。
`todo-table` というテーブルを作り、`todoMessage` をパーテーションキーに、`todoDate` をソートキーに設定します。

![Create DynamoDB](11.png)

`todo-table` にデータを入れていきます。

```
aws dynamodb put-item \
--table-name todo-table \
--item '{ "todoMessage": { "S": "Clean My Room" }, "todoDate": { "S": "2022-03-20T00:00:00Z" } }'
```

```
aws dynamodb put-item \
--table-name todo-table \
--item '{ "todoMessage": { "S": "Shopping" }, "todoDate": { "S": "2022-03-19T00:00:00Z" } }'
```

```
aws dynamodb put-item \
--table-name todo-table \
--item '{ "todoMessage": { "S": "Programing" }, "todoDate": { "S": "2022-03-18T00:00:00Z" } }'
```

追加したデータを確認します。

```
aws dynamodb scan \
--table-name todo-table \
--limit 10 | jq
```

```
aws dynamodb scan \
--table-name todo-table \
--filter-expression 'attribute_exists(todoMessage)' \
--filter-expression 'attribute_exists(todoDate)' \
--limit 100 | jq
```

Lambda関数のロールに DynamoDB へのアクセス権限を付与します。

![Select Lambda Role](12.png)

![Attach Policy](13.png)

![Attach DynamoDB Full Access Policy](14.png)

権限を付与したら Lambda のソースコードを変更します。
Item をスキャンして返します。

```
import json
import boto3

def lambda_handler(event, context):    
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table('todo-table')
    
    scan_kwargs = {
        'FilterExpression': 'attribute_exists(todoMessage)',
        'FilterExpression': 'attribute_exists(todoDate)',
        'Limit': 100,
    }
    
    response = table.scan(**scan_kwargs)
    items = response['Items']    
    
    return {
        'statusCode': 200,
        'body': json.dumps(items),
    }
```

再び API Gateway のエンドポイントにブラウザからアクセスして Todoリストを確認できれば完成です。
