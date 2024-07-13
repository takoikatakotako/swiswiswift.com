+++
title =  "Swiftで配列からランダムに要素を取り出す"
url = "2022-05-10"
date = "2022-05-10"
description = "Swiftで配列からランダムに要素を取り出す"
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

Swiftで配列からランダムに要素を取り出す方法です。
配列をシャッフルした後に先頭の要素を取得しています。

```swift
// 0, 1, 2, ... 9 の配列からランダムに5要素抽出する
var numbers: [Int] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print(numbers)  // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

// 配列をシャッフルする
numbers.shuffle()
print(numbers)  // [1, 7, 9, 4, 6, 2, 0, 3, 8, 5]

// .prefix を使い先頭の5要素を取得する。prefix の戻り値の型は Array<T> ではなく、ArraySlice<T> なので変換する必要がある。
let arraySlicedNumbers: ArraySlice<Int> = numbers.prefix(5)
let slicedNumbers: [Int] = Array(arraySlicedNumbers)
print(slicedNumbers)    // [1, 7, 9, 4, 6]
```
