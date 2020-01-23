+++
title = "SafeAreaを取得する"
url = "2018-09-19"
date = "2018-09-19"
description = "SafeAreaを取得する"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2018/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

iPhoneXが登場したことで、iPhoneXのレイアウト(SafeAreaの取得)には気を使うようになりました。  
SafeAreaはviewDidLayoutSubviews メソッド内で、safeAreaInsets プロパティを参照することで取得することができます。  

![alt](1.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako f464fc7f9a01303fef01895ef66e1346 >}}
