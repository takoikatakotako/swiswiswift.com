+++
title =  "Swiftで仮引数を持つイニシャライザをスマートに書く"
url = "2020-08-09"
date = "2020-08-09"
description = "Swiftで仮引数を持つイニシャライザをスマートに書く"
tags = [
  "Swift",
  "iOS"
]
categories = [
  "Swift",
  "iOS"
]
archives = "2020/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

Swiftで仮引数を持つイニシャライザをスマートに書く方法です。
仮引数がついたイニシャライザをもち、イニシャライズ時の値を定数として保持する Struct を作る時、<code>private(set) var name = "snorlax"</code> を使うと短くスマートに書くことができます。
プロパティが増えてもイニシャライザを編集する必要が無くなります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 20027c0b03521ba40788f34269f612d9 >}}
