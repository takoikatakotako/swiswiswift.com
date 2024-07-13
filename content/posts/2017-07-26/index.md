+++
title = "curlでpostでJson送るときにレスポンスヘッダーも確認したい"
url = "2017-07-26"
date = "2017-07-26"
description = "curlでpostでJson送るときにレスポンスヘッダーも確認したい"
tags = [
    "Linux",
]
categories = [
    "Linux",
]
archives = "2017/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

curlでpostでJson送るときにレスポンスヘッダーも確認したい時に使いました。
最後に `--include` をつけるとレスポンスヘッダーも表示されます。

```
http://localhost:3000/api/url -X POST -H "Content-Type: application/json" -d '{"email":"user@swiswiswift.com", "password":"password"}'--include
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
