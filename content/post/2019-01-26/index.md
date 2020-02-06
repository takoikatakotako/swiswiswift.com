+++
title = "SwiftでUITestを導入(Swift4.2)"
url = "2019-01-26"
date = "2019-01-26"
description = "SwiftでUITestを導入(Swift4.2)"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2019/01"
aliases = ["migrate-from-jekyl"]
+++

<br>

プロジェクトにUITestを追加します。  
プロジェクト作成時に作らなかった場合は以下の画像の手順で追加することができます。



`@testable import Swiswiswift`（Swiswiswiftはプロジェクト名）　と書くことで、テストクラスの中から参照できるようになります。  
関数名の頭にtestと付けることで、テストとして実行できるようになります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 026e20c64d4aa955e079024a7ea9340a >}}
