+++
title =  "UIActivityViewControllerでText, JSON, PDFを共有する"
url = "2020-04-02"
date = "2020-04-02"
description = "UIActivityViewControllerでText, JSON, PDFを共有する"
tags = [
    "Swift"
]
categories = [
    "Swift"
]
archives = "2020/04"
aliases = ["migrate-from-jekyl"]
+++

<br>
UIActivityViewControllerでText, JSON, PDFを共有する方法です。
簡単にファイルが共有できて実装が簡単なので重宝しています。
画像、PDFなどは Data を渡しても認識しますが、JSON などは Data を渡しても認識しないので、ファイルパスを指定しています。

![UIActivityViewController](1.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako f348d3919c3ad16d6a9e4d91a8ef0e32 >}}
