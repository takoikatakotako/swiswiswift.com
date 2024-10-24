+++
title = "UILabel"
url = "2017-05-09"
date = "2017-05-09"
description = "UILabel"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2017/05"
aliases = ["migrate-from-jekyl"]
+++

<br>

UILabelクラスは文字表示を管理するクラスです。画面に文字を表示させたい時に使用します。

UILabelのクラス階層

NSObject  
↑  
UIResponder  
↑  
UIView  
↑  
UILabel  

[AppleDeveloperリファレンス UILabel](https://developer.apple.com/documentation/uikit/uilabel)




UILabelサンプル

サンプルコード

![alt](1.png)

{{< gist takoikatakotako 6b60db47265f949ded1ee50517b25a5a >}}


UILabelのカスタマイズ

UILabelにタッチイベントを実装
参考: [[Swift2.0] UILabelとUIImageViewのタップイベント処理を実装する](https://qiita.com/k-yamada-github/items/79bb31cff50dc9fca321)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 0fb9d9197ce5817e365b064adbd2b409 >}}
