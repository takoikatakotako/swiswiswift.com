+++
title =  "SwiftUIでAVAudioPlayerNodeで音楽を再生し、再生終了を検知する"
url = "2020-12-14"
date = "2020-12-14"
description = "SwiftUIでAVAudioPlayerNodeで音楽を再生し、再生終了を検知する"
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

SwiftUIでAVAudioPlayerNodeで音楽を再生し、再生終了を検知する方法です。
AVAudioPlayer は Delegate で再生終了を検知しますが、AVAudioPlayerNodeは再生終了時に呼ばれるハンドラーが用意されているのでそちらを使います。

参考: [AVAudioEngine & AVAudioPlayerNode didFinish method like AVAudioPlayer](https://stackoverflow.com/questions/34238432/avaudioengine-avaudioplayernode-didfinish-method-like-avaudioplayer)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 7f3fd96f99887e7e1664837b05d638ae >}}
