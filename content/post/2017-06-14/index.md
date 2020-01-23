+++
title = "UIImagePickerControllerで画像の選択"
url = "2017-06-14"
date = "2017-06-14"
description = "UIImagePickerControllerで画像の選択"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2017/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

iPhoneのフォトライブラリから画像を取得するサンプルプログラムです。  

フォトライブラリから画像を選択するために、プロジェクトの `info.plist` にフォトライブラリを使用する旨を記述します。  
これを書いておかないとUIImagePickerControllerは使えません。  
キーの値は以下の値を使います。  
`NSPhotoLibraryUsageDescription`  
Typeは `String` でValueの中に使用理由を書きます。  
使用理由を書かないと審査の時に落とされるらしいです。  
下の画像のような感じです。  

![alt](1.png)
![alt](2.png)
![alt](3.png)
![alt](4.png)


コードは以下のようになります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako e30e9e82f7b46da3deac632f74a7cc02 >}}
