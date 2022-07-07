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
archives = "2021/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

curlでLambdaの関数URLにリクエストを送る方法です。
Lambdaと関数URLの作成方法は [こちら](/2022-06-07/) を参考にしてください。

### Lmabdaにデータを送る

`snorlax` を送る。

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
curl -X POST -d 'snorlax' https://kpbgp7tjt7yyoyerlj3upsb6uu0jjlct.lambda-url.ap-northeast-1.on.aws/ | jq
```

```
{
  "pokemon": "snorlax"
}
```


### LmabdaにJSONデータを送る

`{"pokemon":"snorlax"}` を送る。

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
curl -X POST -d '{"pokemon":"snorlax"}' https://kpbgp7tjt7yyoyerlj3upsb6uu0jjlct.lambda-url.ap-northeast-1.on.aws/ | jq
```

```
{
  "pokemon": "snorlax"
}
```


### LmabdaにContextType付きでJSONデータを送る

`{"pokemon":"snorlax"}` を送る。

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
curl -X POST -H "Content-Type: application/json" -d '{"pokemon":"snorlax"}' https://kpbgp7tjt7yyoyerlj3upsb6uu0jjlct.lambda-url.ap-northeast-1.on.aws/ | jq
```

```
{
  "pokemon": "snorlax"
}
```



