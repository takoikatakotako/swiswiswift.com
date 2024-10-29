+++
title =  "Swiftで録画開始とスクリーンショットが取られたことを検知する"
url = "2020-06-15"
date = "2020-06-15"
description = "Swiftで録画開始とスクリーンショットが取られたことを検知する"
tags = [
    "Swift",
    "iOS"
]
categories = [
    "Swift",
    "iOS"
]
archives = "2020/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

Swiftで録画開始とスクリーンショットが取られたことを検知する方法です。
画面録画開始前に captureStatusDidChange を実行させることができるのですが、スクリーンショット撮影前に captureStatusDidChange を実行させることはできませんでした。
もしスクリーンショットを取られてしまっては不味いものがある場合、動画であれば DRM を使用したり、サードパーティーの [ScreenShieldKit](https://screenshieldkit.com/) を使用する必要があります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 16f3b9d8c31429191a0b8cc2288d0411 >}}
