+++
title = "Swift3からSwift4への移行時に出る@objc inference warningsを消す"
url = "2017-11-25"
date = "2017-11-25"
description = "Swift3からSwift4への移行時に出る@objc inference warningsを消す"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2017/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

Xcode8からXcode9へ乗り換えてSwift4へ変換すると以下のエラーが出ます。それの消し方です。  

```
The use of Swift 3 @objc inference in Swift 4 mode is deprecated. Please address deprecated @objc inference warnings, test your code with “Use of deprecated Swift 3 @objc inference” logging enabled, and then disable inference by changing the "Swift 3 @objc Inference" build setting to "Default" for the "TargetName" target.
```

各ターゲットを選択 -> Build Settings -> 検索窓で inference と検索 -> Swift @objc inference を Default　に設定する　  
他にもターゲット(UITest,UnitTest)がある場合はそれも Default　に設定する。  
これで消えるはずです！  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
