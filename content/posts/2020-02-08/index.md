+++
title =  "SwiftUIでFirestoreの画像を表示する"
url = "2020-02-08"
date = "2020-02-08"
description = "SwiftUIでFirestoreの画像を表示する"
tags = [
    "Swift", "SwiftUI", "Firebase"
]
categories = [
    "Swift", "SwiftUI", "Firebase"
]
archives = "2020/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftUI で Firestore の画像を表示する方法です。
UIImage は SDWebImage を使えば簡単に表示できますが、SwiftUI ではそれができません。
[SDWebImage/SDWebImageSwiftUI](https://github.com/SDWebImage/SDWebImageSwiftUI)を使って以下のように書いてみました。
もっと良い書き方がある気がします、これだとトークンも含めてキャッシュされちゃうような。。。

参考:
[iOS でファイルをダウンロードする](https://firebase.google.com/docs/storage/ios/download-files?hl=ja)
[SDWebImage/SDWebImageSwiftUI](https://github.com/SDWebImage/SDWebImageSwiftUI)


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 255a693ee8426fa4fe1c24830be40935 >}}
