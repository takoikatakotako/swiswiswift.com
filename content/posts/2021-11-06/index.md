+++
title =  "Swiftで引数を参照渡しをする"
url = "2021-11-06"
date = "2021-11-06"
description = "Swiftで引数を参照渡しをする"
tags = [
  "Swift"
]
categories = [
  "Swift"
]
archives = "2021/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

Swiftで引数を参照渡しをする方法です。
まず普通に書いた場合です。
プログラム実行後 x = 2, y = 4 となります。

```swift
import UIKit

let x: Int = 2

func double(num: Int) -> Int {
    return x * 2
}

let y: Int = double(num: 2)
print("x = \(x), y = \(y)")    // x = 2, y = 4
```

Swiftで引数を参照渡しをする方法です。
inout で引数を参照私にすることができます。
プログラム実行後 x = 4, y = 4 となります。

```swift
import UIKit

var x: Int = 2

func inoutDouble ( num: inout Int) -> Int{
    num = num * 2
    return num
}

let y = inoutDouble(num: &x)
print("x = \(x), y = \(y)")     // x = 4, y = 4
```