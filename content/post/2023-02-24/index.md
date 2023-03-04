+++
title = "UserDefaultsで複数の値をセットで保存する"
url = "2023-02-24"
date = "2023-02-24"
description = "UserDefaultsで複数の値をセットで保存する"
tags = [
  "Swift"
]
categories = [
  "Swift"
]
archives = "2023/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

UserDefaultsで複数の値をセットで保存する方法です。
辞書型配列を使う方法と保存用のstructを作成する方法でサンプルコードを作成しました。
Set ボタンを押すと UserDefaults にカビゴンの情報が保存され、Get ボタンを押すとカビゴンの情報をコンソールに出力します。

{{< figure src="20230224.png" width="400" >}}


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}


### 辞書型配列を使う方法

{{< gist takoikatakotako e2aa587a07910eceee2e0a3fc920a554 >}}

### 保存用のstructを作成する方法

{{< gist takoikatakotako 9ade656a70885035a89dd64e0da12fbc >}}
