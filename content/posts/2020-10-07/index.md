+++
title =  "SwiftUIでListの中に複数のNavigationLinkを設置する"
url = "2020-10-07"
date = "2020-10-07"
description = "SwiftUIでListの中に複数のNavigationLinkを設置する"
tags = [
  "SwiftUI",
  "Swift",
  "iOS"
]
categories = [
  "SwiftUI",
  "Swift",
  "iOS"
]
archives = "2020/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftUIでListの中に複数のNavigationLinkを設置する方法です。
素直に実装すると画面遷移が暴発してしまいます。

![MultiNavigationLink](1.gif)

それを修正するために List のタップジェスチャーを無効化したりする必要がありました。

![MultiNavigationLink](2.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 0394bc60b3723561d7fd9c50cc00fbb0 >}}
