+++
title = "Swiftでモーダル表示時にviewWillDisappearが呼ばれない"
url = "2023-02-23"
date = "2023-02-23"
description = "Swiftでモーダル表示時にviewWillDisappearが呼ばれない"
tags = [
  "SwiftUI"
]
categories = [
  "SwiftUI"
]
archives = "2023/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

Swiftでモーダル表示時にviewWillDisappearが呼ばれないということが起きました。
以下のようにボタンを押したタイミングでフルスクリーンのモーダルが表示されるとします。

![Modal](20230223.gif)

`modalPresentationStyle` を `.fullScreen` にすると `viewWillDisappear` と `viewDidAppear` がモーダル表示のタイミングで呼ばれますが、`.overFullScreen` にすると `viewDidAppear` しか呼ばれませんでした。

参考: [iOSにおけるモーダル表示まとめ](https://blog.asial.co.jp/1669)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako ff75308f7e76ab99ce70217bfd6bc75e >}}

