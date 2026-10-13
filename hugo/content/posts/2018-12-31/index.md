+++
title = "Print(Swift4.2)"
url = "2018-12-31"
date = "2018-12-31"
description = "Array(Swift4.2)"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2019/01"
+++

<br>

#Swift4.2  
print文を使うことでコンソールに配列の中身や文字列などの情報を出力することができます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}


<!--more-->

**print.swift**

```swift
import UIKit

let hello = "Hello"
let world = "World"

// HelloWorld
print(hello + world)

// 引数は1つ以上、好きな個数指定でき、異なる型が混在していてもOK
// String 3.14156 42 2018-10-24 14:16:33 +0000
print("String", 3.14156, 42, Date())

// separatorを指定することで、好きな区切り文字を指定できる
// Hello-World-3.1415
print("Hello", "World", separator: "-")

// terminatorを指定することで、好きな区切り文字を指定できる
// Hello World (続けて出力される)
print("Hello", terminator: " ")
print("World")
```

