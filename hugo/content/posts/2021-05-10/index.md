+++
title =  "iOSでバージョンとビルド番号を取得する"
url = "2021-05-10"
date = "2021-05-10"
description = "iOSでバージョンとビルド番号を取得する"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2021/05"
+++

<br>

iOSでバージョンとビルド番号を取得する方法です。
バージョンとビルド番号を文字列で取得します。
オプショナルで取得することになるので、if let でアンラップしてます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Main.swift**

```swift
if let version = Bundle.main.object(forInfoDictionaryKey: "CFBundleShortVersionString") as? String,
   let build = Bundle.main.object(forInfoDictionaryKey: "CFBundleVersion") as? String {
    print("version: \(version), build \(build)")
}
```


