+++
title =  "SwiftでMapViewの中央に十字を用意し、その中央の座標を取得する"
url = "2021-11-12"
date = "2021-11-12"
description = "SwiftでMapViewの中央に十字を用意し、その中央の座標を取得する"
tags = [
  "iOS",
  "UIKit"
]
categories = [
  "iOS",
  "UIKit"
]
archives = "2021/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftでMapViewの中央に十字を用意し、その中央の座標を取得する方法です。
スクロールしたりピンチしたタイミングで `regionDidChangeAnimated` が呼ばれるので、その時の中心の座標を取得しています。

![Image](1.gif)

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

{{< gist takoikatakotako 16e9e89623f86b6c6d0f986c62e02cf4 >}}
