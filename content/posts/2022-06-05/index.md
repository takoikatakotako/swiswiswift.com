+++
title =  "iOSのファイルアプリ（UIDocumentPickerViewController）を開いてドキュメントフォルダに保存したファイルを開く"
url = "2022-06-05"
date = "2022-06-05"
description = "iOSのファイルアプリ（UIDocumentPickerViewController）を開いてドキュメントフォルダに保存したファイルを開く"
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

iOSのファイルアプリ（UIDocumentPickerViewController）を開いてドキュメントフォルダに保存したファイルを開く方法です。

![Preview](1.gif)

`info.plist` にファイルアプリでドキュメントディレクトリを開けるように `Supports opening documents in place` と `Application supports iTunes file sharing` を追加し、どちらも `YES` に設定します。

![plist](1.png)

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

{{< gist takoikatakotako 9fafd9750fb0f843daf8d6f3e3ecf82a >}}

