+++
title =  "DynamoDBのItemを一度に削除する（batch-write-item）"
url = "2022-06-09"
date = "2022-06-09"
description = "DynamoDBのItemを一度に削除する（batch-write-item）"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2021/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

DynamoDBのItemを一度に削除する方法です。
`batch-write-item` を使うことで一度に削除することができます。
今回はLocalStackで試したので、`--endpoint-url` オプションを使用しています。
AWSの場合は最後の行を除いて実行してください。


## テーブルを作成

`pokemon-table` という名前でテーブルを作成します。
プライマリーキーに `pokemonID` を指定します。

```
$ aws dynamodb create-table \
    --table-name pokemon-table \
    --attribute-definitions AttributeName=pokemonID,AttributeType=S \
    --key-schema AttributeName=pokemonID,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
    --endpoint-url=http://localhost:4566
```


## Itemの追加

`Snorlax`, `Ditto`, `Pikachu`, `Eevee` の4つのItemを追加します。

```
$ aws dynamodb put-item \
    --table-name pokemon-table \
    --item '{"pokemonID": {"S": "Snorlax"}}' \
    --endpoint-url=http://localhost:4566 | jq
```

```
$ aws dynamodb put-item \
    --table-name pokemon-table \
    --item '{"pokemonID": {"S": "Ditto"}}' \
    --endpoint-url=http://localhost:4566 | jq
```

```
$ aws dynamodb put-item \
    --table-name pokemon-table \
    --item '{"pokemonID": {"S": "Pikachu"}}' \
    --endpoint-url=http://localhost:4566 | jq
```

```
$ aws dynamodb put-item \
    --table-name pokemon-table \
    --item '{"pokemonID": {"S": "Eevee"}}' \
    --endpoint-url=http://localhost:4566 | jq
```


## テーブルの中のItemをすべて表示

4つのItemがあることがわかります。

```
$ aws dynamodb scan \
    --table-name pokemon-table \
    --endpoint-url=http://localhost:4566 | jq
```


## Itemを一度に削除する

`batch-write-item` を使い、Itemを一度に削除します。

```
$ aws dynamodb batch-write-item \
  --request-items '{"pokemon-table":[{"DeleteRequest":{"Key":{"pokemonID":{"S":"Snorlax"}}}},{"DeleteRequest":{"Key":{"pokemonID":{"S":"Ditto"}}}},{"DeleteRequest":{"Key":{"pokemonID":{"S":"Pikachu"}}}},{"DeleteRequest":{"Key":{"pokemonID":{"S":"Eevee"}}}}]}' \
  --endpoint-url=http://localhost:4566 | jq
```

`--request-items` のJSONの内容はこちらです。

```
{
   "pokemon-table":[
      {
         "DeleteRequest":{
            "Key":{
               "pokemonID":{
                  "S":"Snorlax"
               }
            }
         }
      },
      {
         "DeleteRequest":{
            "Key":{
               "pokemonID":{
                  "S":"Ditto"
               }
            }
         }
      },
      {
         "DeleteRequest":{
            "Key":{
               "pokemonID":{
                  "S":"Pikachu"
               }
            }
         }
      },
      {
         "DeleteRequest":{
            "Key":{
               "pokemonID":{
                  "S":"Eevee"
               }
            }
         }
      }
   ]
}
```


## テーブルの中のItemをすべて表示

Itemが全て消えていることを確認します。

```
$ aws dynamodb scan \
    --table-name pokemon-table \
    --endpoint-url=http://localhost:4566 | jq
```


## 参考

[batch-write-item](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/dynamodb/batch-write-item.html)
