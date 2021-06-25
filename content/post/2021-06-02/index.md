+++
title =  "iOSのファイルアプリを開いてドキュメントフォルダに保存したファイルを開く"
url = "2021-06-02"
date = "2021-06-02"
description = "iOSのファイルアプリを開いてドキュメントフォルダに保存したファイルを開く"
tags = [
  "SwiftUI"
]
categories = [
  "SwiftUI"
]
archives = "2021/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

iOSのファイルアプリを開いてドキュメントフォルダに保存したファイルを開く方法です。

![ファイル](1.gif)

アプリのドキュメントディレクトリにファイルを保存するアプリを書きます。

![plist](1.png)

{{< gist takoikatakotako acf3246a3d2d1d0b909f85cf2de6d6c2 >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}


次に `info.plist` にファイルアプリでドキュメントディレクトリを開けるように設定を追加します。

![plist](2.png)

