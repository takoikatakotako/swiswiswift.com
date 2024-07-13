+++
title =  "LambdaとEvent BridgeでDiscordの目覚ましBotを作る"
url = "2022-02-07"
date = "2022-02-07"
description = "LambdaとEvent BridgeでDiscordの目覚ましBotを作る"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

LambdaとEvent BridgeでDiscordの目覚ましBotを作る方法です。
「おはよう」と毎朝つぶやくDiscordのBotを作ります。

まずDiscordでウェブフックを作成します。
curlコマンドを使い、メッセージが届くことを確認します。
https://discord.com/api/webhooks/xxx/xxx は差し替えてください。

```
export WEBHOOK_URL="https://discord.com/api/webhooks/xxx/xxx"
curl \
  -H "Content-Type: application/json" \
  -d '{"username": "おはようBot", "content": "おはようございます。"}' \
  $WEBHOOK_URL
```

届いたことを確認したら上記curl文をPythonで書き換えます。
書き換えたものが以下です。

```
import urllib.request
import json

def main():
    url = 'https://discord.com/api/webhooks/xxx/xxx'
    message = {'username': 'おはようBot', 'content' : 'おはようございます！'}
    data = json.dumps(message).encode("utf-8")
    request = urllib.request.Request(
        url = url,
        data = data,
        headers = {"User-Agent": "lambda/python", "Content-Type" : "application/json"},
        method = 'POST'
    )
    with urllib.request.urlopen(request) as response:
        response_body = response.read().decode("utf-8")
        print(response_body)


def lambda_handler(event, context):
    main()

if __name__ == '__main__':
    main()
```

マネジメントコンソールから Lambda を作成します。

![Create](1.png)

ソースコードを書き換えます。

![Edit](2.png)

Event Bridge にトリガーを設定します。

![Setting](3.png)

このように設定され、毎分Discordにメッセージが届けば完了です。
Cronの時刻はGMTなので日本時刻とは時差があるので注意が必要です。

![Edit](4.png)

