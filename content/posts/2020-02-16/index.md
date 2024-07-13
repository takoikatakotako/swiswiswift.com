+++
title =  "SwiftでCSVを集計する"
url = "2020-02-16"
date = "2020-02-16"
description = "SwiftでCSVを集計する"
tags = [
    "Swift"
]
categories = [
    "Swift"
]
archives = "2020/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

Swift で CSV を集計する方法です。
まず前処理として、CSV ファイルを utf8 に変換する必要があります。
Mac の場合は Numbers で開き、CSV で保存すると上手く行きました。

```
$ swift main.swift
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako cfeac64f22dc5144c6211b2b418c07ee >}}
