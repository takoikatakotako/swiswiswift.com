+++
title =  "cURL（curl）でアプリにプッシュ通知を送信する"
url = "2019-11-06"
date = "2019-11-06"
description = "cURL（curl）でアプリにプッシュ通知を送信する"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2019/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

curl コマンドで iOS端末にプッシュ通知を送信する方法です。

証明書と秘密鍵の両方を含めたpemファイルを作成します。

{{< highlight html >}}
$ openssl pkcs12 -in xxxx.p12 -nodes -out certificate-and-privatekey.pem
{{< /highlight >}}

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

`curl` コマンドでプッシュ通知を送信します。  
プッシュペイロード、トピック、デバイストークンは使用している環境のものを使ってください。  
また、本番環境（テストフライトなど）と開発環境ではドメイン (https://api.push.apple.com/3/device/ or https://api.development.push.apple.com) が違うことに気をつけてください。  


{{< highlight html >}}
# for 本番環境
$ curl -v -d '{"aps":{"alert":"hello"}}' -H "apns-topic: com.swiswiswift.myapp" --http2 --cert certificate-and-privatekey.pem https://api.push.apple.com/3/device/{your_device_token}
# for 開発環境
$ curl -v -d '{"aps":{"alert":"hello"}}' -H "apns-topic: com.swiswiswift.myapp" --http2 --cert certificate-and-privatekey.pem https://api.development.push.apple.com/3/device/{your_device_token}
{{< /highlight >}}
