+++
title =  "SwiftでSetから要素を削除する"
url = "2022-05-06"
date = "2022-05-06"
description = "SwiftでSetから要素を削除する"
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

SwiftでSetから要素を削除する方法です。
`remove` を使うことで要素を削除することができます。

```
var mySet: Set = [1, 2, 3, 4]
mySet.remove(3)
print(mySet)    // [1, 2, 4]
```

存在しない要素に対して `remove` しても例外は発生しません。

```
var mySet: Set = [1, 2, 3, 4]
mySet.remove(6)
print(mySet)    // [4, 2, 3, 1]
```
