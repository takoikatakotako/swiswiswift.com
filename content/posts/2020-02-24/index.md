+++
title =  "SwiftUIでButton内の画像の色を変えない"
url = "2020-02-24"
date = "2020-02-24"
description = "SwiftUIでButton内の画像の色を変えない"
tags = [
    "Swift"
]
categories = [
    "Swift"
]
archives = "2020/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftUIでButton内の画像の色を変えない方法です。
デフォルトのままだと以下の画像のように色が青く変わってしまいます。

![ButtonColor](1.png)

`renderingMode(.original)` と設定することで、元の画像の色が表示されました。

![ButtonColor](2.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 5f965173af83b27d15e60f65ef0031a5 >}}
