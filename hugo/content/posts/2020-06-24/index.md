+++
title =  "SwiftUIでUITestを動かす"
url = "2020-06-24"
date = "2020-06-24"
description = "SwiftUIでUITestを動かす"
tags = [
    "SwiftUI",
    "iOS"
]
categories = [
    "SwiftUI",
    "iOS"
]
archives = "2020/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftUIでUITestを動かす方法です。
UIKit の時と違って sleep を入れないと良い感じに動かなかったです。
State が変わると際レンダリングが走るせいでしょうか？

![SwiftUI UITests](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako acf5be07513fdee750802d43dd3fd6f9 >}}
