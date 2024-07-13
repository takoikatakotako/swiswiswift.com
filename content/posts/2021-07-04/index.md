+++
title =  "複数の型を持つJSONをemumでDecodeする"
url = "2021-07-04"
date = "2021-07-04"
description = "複数の型を持つJSONをemumでDecodeする"
tags = [
  "SwiftUI"
]
categories = [
  "SwiftUI"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

複数の型を持つ JSON を enum を使って Decode する方法です。
とある API を叩くと JSON が返ってきますが、その中身がポケモンなのかトレーナーなのかジムリーダーなのかわかりません。
以下のコードのように enum の Character の中に Pokemon, GymLeader, Trainer を定義することで、どのような JSON が来ても Decode できるようになります。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

{{< gist takoikatakotako b44160ebe349a13f43fd5d92f4a4eef2 >}}
