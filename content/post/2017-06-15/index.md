+++
title = "Swiftでクラス名と関数名と行番号を取得、表示する"
url = "2017-06-15"
date = "2017-06-15"
description = "Swiftでクラス名と関数名と行番号を取得、表示する"
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

「ここは動いたらヤバい！」的な箇所に書くとでデバックが捗ります。  
クラス名と行番号、取得表示することができます。  


```
print("Class name : \(NSStringFromClass(type(of: self))) ")
print(#function, #line)
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
