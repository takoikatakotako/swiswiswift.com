+++
title =  "curlでLambdaの関数URLにデータ付きでリクエストを送る"
url = "2022-07-01"
date = "2022-07-01"
description = "curlでLambdaの関数URLにデータ付きでリクエストを送る"
tags = [
  "AWS",
  "Python",
  "JavaScript"
]
categories = [
  "AWS",
  "Python",
  "JavaScript"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

curlでLambdaの関数URLにリクエストを送る方法です。
Lambdaと関数URLの作成方法は [こちら](/2022-06-07/) を参考にしてください。

### Lmabdaにデータを送る

Lambda に `snorlax` というデータを送ります。
受け取ったデータは `event['body']` で受け取ることができますが、base64でデコードする必要があります。

```
import json
import base64

def lambda_handler(event, context):
    body = event['body']
    decoded_body = base64.b64decode(body).decode()

    response = {
        'pokemon': decoded_body
    }

    return {
        'statusCode': 200,
        'body': json.dumps(response)
    }
```

```
curl -X POST -d 'snorlax' {ENDPOINT_URL} | jq
```

```
{
  "pokemon": "snorlax"
}
```


### LmabdaにJSONデータを送る

Lambda に `{"pokemon":"snorlax"}` というデータを送ります。
受け取ったデータは `event['body']` で受け取ることができますが、base64でデコードし、mapに変換する必要があります。

```
import json
import base64

def lambda_handler(event, context):
    print('---')
    print(event['body'])
    print('---')
    
    body = event['body']
    decoded_body = base64.b64decode(body).decode()
    body_json= json.loads(decoded_body)
    pokemon = body_json['pokemon']

    response = {
        'pokemon': pokemon
    }

    return {
        'statusCode': 200,
        'body': json.dumps(response)
    }
```

```
curl -X POST -d '{"pokemon":"snorlax"}' {ENDPOINT_URL} | jq
```

```
{
  "pokemon": "snorlax"
}
```


### LmabdaにContextType付きでJSONデータを送る

Lambda に `{"pokemon":"snorlax"}` というデータを `Content-Type: application/json` ヘッダー付きで送ります。
受け取ったデータは `event['body']` で受け取ることができ、base64でデコードせずとも、mapに変換することができます。

```
import json

def lambda_handler(event, context):
    body = event['body']
    body_json = json.loads(body)
    pokemon = body_json['pokemon']

    response = {
        'pokemon': pokemon
    }

    return {
        'statusCode': 200,
        'body': json.dumps(response)
    }
```

```
curl -X POST -H "Content-Type: application/json" -d '{"pokemon":"snorlax"}' {ENDPOINT_URL} | jq
```

```
{
  "pokemon": "snorlax"
}
```



