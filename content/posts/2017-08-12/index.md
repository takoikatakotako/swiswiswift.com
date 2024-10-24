+++
title = "輸出コンプライアンスのウィザードをスキップする"
url = "2017-08-12"
date = "2017-08-12"
description = "輸出コンプライアンスのウィザードをスキップする"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2017/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

アプリをTestFlightなどに提出すると、暗号化が含まれていないか聞かれます。  
毎回聞かれるとスキップしたくなります。  
`Info.plist` の `ITSAppUsesNonExemptEncryption` を `NO` にするとスキップすることができます。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
