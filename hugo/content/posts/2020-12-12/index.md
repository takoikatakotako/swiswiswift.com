+++
title =  "SwiftUIでAVAudioPlayerで音楽を再生し、再生終了を検知する"
url = "2020-12-12"
date = "2020-12-12"
description = "SwiftUIでAVAudioPlayerで音楽を再生し、再生終了を検知する"
tags = [
  "iOS",
  "SwiftUI"
]
categories = [
  "iOS",
  "SwiftUI"
]
archives = "2020/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftUIでAVAudioPlayerで音楽を再生し、再生終了を検知する方法です。
SwiftUIは struct を使うので AVAudioPlayerDelegate に準拠することができません。
そのため、ViewModel を作成し、SwiftUI（View）から呼び出してあげるます。

参考: [AVAudioPlayerDelegate SwiftUI](https://www.hackingwithswift.com/forums/swiftui/avaudioplayerdelegate-swiftui/2872)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 914be8370652bedcac998c49cbb47099 >}}
