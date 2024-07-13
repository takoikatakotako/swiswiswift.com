+++
title = "Build input file cannot be found: Libraries/WebSocket/libfishhook.a’"
url = "2018-09-27"
date = "2018-09-27"
description = "Build input file cannot be found: Libraries/WebSocket/libfishhook.a’"
tags = [
    "ReactNative",
]
categories = [
    "ReactNative",
]
archives = "2018/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

//参考
[Xcode 10 libfishhook.a cannot be found](https://github.com/facebook/react-native/issues/19569)

Xcodeを10.0 にアップデートしたら上記のエラーが出てReactNativeのコンパイルできなくなった。

RTCWebSocket.xcodeproject -> RCTWebSocket -> Build Phasesを選択 -> Link Binary WithLibraried にlibfishhook.aを追加。  
すでに追加されている場合は削除  

を行うことで解決した。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
