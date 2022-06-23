+++
title =  "LambdaでBMIを計算するAPIを作成する"
url = "2022-06-07"
date = "2022-06-07"
description = "LambdaでBMIを計算するAPIを作成する"
tags = [
  "AWS",
  "Python"
]
categories = [
  "AWS",
  "Python"
]
archives = "2021/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

LambdaでBMIを計算するAPIを作成する方法です。
以下のコードをコードタブに貼り付け関数URLを作成します。
JSから呼び出す場合はCORSの設定を行う必要があります。

![Preview](1.png)

```
curl -X POST -H "Content-Type: application/json" -d '{"hight":170, "weight":60}' {ENDPOINT_URL}
```

```
{
  "bmi": 20.761245674740486
}
```

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

{{< gist takoikatakotako 47068dc30c1774d2364f4821fc8adf6b >}}
