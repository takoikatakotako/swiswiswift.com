+++
title = "curlでpostでJson送る"
url = "2017-07-25"
date = "2017-07-25"
description = "curlでpostでJson送る"
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

Macのターミナルからcurlコマンドでjsonをpostする方法です。  
ローカルで開発をしていて、apiの確認をしたい時によく使います。  

```
curl http://localhost:3000/api/url -X POST -H "Content-Type: application/json" -d '{"email":"kabigon@swiswiswift.com", "password":"password"}'
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
