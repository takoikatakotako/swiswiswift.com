+++
title =  "Swiftで16進数を使う"
url = "2022-05-09"
date = "2022-05-09"
description = "Swiftで16進数を使う"
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

Swiftで16進数を使う方法です。
`0x` を使うことで16進数を表現できます。(1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f, 10, 11, 12, ..., 19, 1a, 1b)

`0x12` は10進数で18です。

```swift
let number: Int = 0x12
print(number)   // 18
```
