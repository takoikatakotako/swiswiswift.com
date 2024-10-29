+++
title = "現在の日付と曜日、現在時間を取得する"
url = "2018-04-20"
date = "2018-04-20"
description = "現在の日付と曜日、現在時間を取得する"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2018/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

Swift4.1で現在の日付と曜日、現在時間を取得するサンプルコードです。  
以下の形式の文字列で取得してくれます。  

2018/04/03 (木)  
19:03:34  

上のような形式で取得するサンプルコードです。  

Calendar.currentで取得すると、設定によっては和暦(平成〇〇年)で取得してしまう可能性があるので(2018/04/03が欲しいのに30/04/03が帰ってくる)、グレゴリオ暦で取得する方が無難です。  
逆に和暦が欲しいときは和暦で取得する方法もあります。  

このサイトが詳しいです。  
[Swift 3 の日時操作チートシート](https://qiita.com/mishimay/items/8d67b583dc6809b2baf5)  

その他参考にさせていただいたサイト  
[Swift3での日時に関する処理](https://qiita.com/isom0242/items/e83ab77a3f56f66edd2f)  
[【Swift3】現在時刻の取得とDataFormatterでの文字列化](https://qiita.com/GDaigo/items/270e6ed6e898e8b8e1c3)  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 9f029788e0b3ea4985719a87d657614b >}}
