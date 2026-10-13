+++
title = "Function(Swift4.2)"
url = "2019-01-02"
date = "2019-01-02"
description = "Function(Swift4.2)"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2019/01"
+++

<br>

Swiftで関数を作る方法です。
最近はネット記事を見ないでも見なくても書けるようになってきました。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Function.swift**

```swift
import UIKit

// 横幅と縦幅から面積を計算
func area(height: Double, width: Double) -> Double {
    return height * width
}

// 引数名と関数の中での変数名が異なる
func area2(height h: Double, width w: Double) -> Double {
    return h * w
}

// 引数名を省略
func area3(_ h: Double, _ w: Double) -> Double {
    return h * w
}

// 面積を求める
print(area(height: 3.00, width: 3.00))
print(area2(height: 3.00, width: 3.00))
print(area3(3.00, 2.00))


// 参照渡し
func double(_ x: inout Int) {
    x = x * 2
}

var x = 100
var y = 0
print("x = \(x)")
// x = 100
double(&x)
print("x = \(x)")
// x = 200
```

