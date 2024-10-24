+++
title =  "curl で iOSにVoIPプッシュを送る"
url = "2020-09-02"
date = "2020-09-02"
description = "curl で iOSにVoIPプッシュを送る"
tags = [
  "Swift",
  "iOS"
]
categories = [
  "Swift",
  "iOS"
]
archives = "2020/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

curl で iOSにVoIPプッシュを送る方法です。
まず VoIPプッシュ通知用の .p12 ファイルを .pem に変換します。

<code>openssl pkcs12 -in file-name.p12 -out file-name.pem -nodes -clcerts</code>

.pem ファイルを使ってプッシュ通知を送ります。apple の URL は配布方法によって異なるので気をつけてください。
たとえば Xcode から実機に送ると以下の URL で良いですが、TestFlightやストアから配布する場合は URL 中の develop は不要です。

```
curl --http2 \
    -E file-name.pem \
    --header "apns-topic: {YOUR_BUNDLE_ID}.voip" \
    -d "{\"message\":\"Hello\"}" \
    https://api.development.push.apple.com/3/device/{YOUR_TOKEN}
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

