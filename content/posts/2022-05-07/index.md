+++
title =  "Swiftで関数の引数にジェネリクスを使う"
url = "2022-05-07"
date = "2022-05-07"
description = "Swiftで関数の引数にジェネリクスを使う"
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

Swiftで関数の引数にジェネリクスを使う方法です。
以下のように記述することで、引数に Int でも String でも受け取ることが可能になります。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

```swift
func createTuple<T>(a: T, b: T) -> (T, T) {
    return (a, b)
}

let stringTuple: (String, String) = createTuple(a: "Snorlax", b: "Ditto")
print(stringTuple)  // ("Snorlax", "Ditto")

let intTuple: (Int, Int) = createTuple(a: 143, b: 132)
print(intTuple) // (143, 132)
```
