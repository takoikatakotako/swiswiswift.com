+++
title =  "Swiftで桁数を指定する"
url = "2022-05-08"
date = "2022-05-08"
description = "Swiftで桁数を指定する"
tags = [
  "Swift"
]
categories = [
  "Swift"
]
archives = "2022/05"
aliases = ["migrate-from-jekyl"]
+++

<br>

`e` の後ろに桁数を指定することができます。

```swift
let number: Double = 123e2
print(number)   // 12300.0
```

負の値にすると小数点にできます。

```swift
let number: Double = 123e-4
print(number)   // 0.0123
```
