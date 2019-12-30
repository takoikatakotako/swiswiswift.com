+++
title = "ESP32でRTCモジュールを使う"
url = "2018-03-14"
date = "2018-03-14"
description = "ESP32でRTCモジュールを使う"
tags = [
    "ESP32",
]
categories = [
    "ESP32",
]
archives = "2018/03"
aliases = ["migrate-from-jekyl"]
+++

<br>

ESP32でRTCモジュールを使おうとしたら少し詰まったので記事にしました。
結論を先に書くと、#include　DS1307RTC.h　を一番上に持ってくることで解決しました。
サンプルコードのReadTestのESP32バージョンになります。

使用ライブラリと機材は以下の通りです。

DS1307RTCライブラリ
[github.com/PaulStoffregen/DS1307RTC](https://github.com/PaulStoffregen/DS1307RTC)

ESPr® Developer 32  
<iframe style="width:120px;height:240px;" marginwidth="0" marginheight="0" scrolling="no" frameborder="0" src="https://rcm-fe.amazon-adsystem.com/e/cm?ref=qf_sp_asin_til&t=swiswiswift-22&m=amazon&o=9&p=8&l=as1&IS1=1&detail=1&asins=B01ESFQFI8&linkId=f2cefe0cf4b52f352011b07e58d088ac&bc1=ffffff&lt1=_top&fc1=333333&lc1=0066c0&bg1=ffffff&f=ifr"></iframe>

Rasbee オリジナル MCUのDC 3.3-5.5V DS3231高精度リアルタイムクロックモジュール 精密RTCモジュール 1個 [並行輸入品]  
<iframe style="width:120px;height:240px;" marginwidth="0" marginheight="0" scrolling="no" frameborder="0" src="https://rcm-fe.amazon-adsystem.com/e/cm?ref=qf_sp_asin_til&t=swiswiswift-22&m=amazon&o=9&p=8&l=as1&IS1=1&detail=1&asins=B00YQZFMMQ&linkId=7d3d17cf414e4c8cbdc6a22a0fb8aba1&bc1=ffffff&lt1=_top&fc1=333333&lc1=0066c0&bg1=ffffff&f=ifr"></iframe>


配線図  

![alt](1.jpg)
![alt](2.jpg)

{{< gist O-Junpei c5016cb12a9c643cb5ba06897e4e23db >}}
