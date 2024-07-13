+++
title = "ESP32でSDカードのテキストファイルを読み書きする。"
url = "2017-10-01"
date = "2017-10-01"
description = "ESP32でSDカードのテキストファイルを読み書きする。"
tags = [
    "ESP32",
]
categories = [
    "ESP32",
]
archives = "2017/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

ESP32でSDカードに保存されたテキストファイルを読み書きするサンプルです。  
読み込んで書き込むシンプルなサンプルコードがネットにあまりな無かったので描いてみました。  

SDカードとESPとの配線はこちらのサイトを参考にしました。  
[mgo-tec電子工作](https://www.mgo-tec.com/blog-entry-esp32-wroom-micro-sdhc-01.html)  
いろいろ調べたのですが、プルアップ抵抗はあった方が良いっぽいです。
そして、 [mgo-tec電子工作](https://www.mgo-tec.com/blog-entry-esp32-wroom-micro-sdhc-01.html) にはいつもお世話になっています、ありがとうございます。  

そしてこちらのコードを参考にさせていただきました。  
ArduinoでSDカードにデータを保存する  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 93b08af9a39e3a70521a5d02fcdd38ca >}}
