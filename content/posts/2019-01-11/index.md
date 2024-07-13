+++
title = "ImagePickerControllerで画像を選択する(Swift4.2)"
url = "2019-01-11"
date = "2019-01-11"
description = "ImagePickerControllerで画像を選択する(Swift4.2)"
tags = [
  "iOS",
]
categories = [
    "iOS",
]
archives = "2019/01"
aliases = ["migrate-from-jekyl"]
+++

<br>

`# Swift 4.2`

Swift3の記事はこちら  
UIImagePickerControllerで画像の選択

iPhoneのフォトライブラリから画像を取得するサンプルプログラムです。  
フォトライブラリから画像を選択するために、プロジェクトの info.plistにフォトライブラリを使用する旨を記述します。  
これを書いておかないとUIImagePickerControllerは使えません。  
キーの値は以下の値を使います。  
`NSPhotoLibraryUsageDescription`
TypeはStringでValueの中に使用理由を書きます。  
使用理由を書かないと審査の時に落とされるらしいです。  

![alt](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako a73bf357ab9fe77db1a81c08dc4b62ef >}}
