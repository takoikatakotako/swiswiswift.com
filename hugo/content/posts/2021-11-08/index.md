+++
title =  "SwiftでJSONエンコードするときに数字の桁数を指定する"
url = "2021-11-08"
date = "2021-11-08"
description = "SwiftでJSONエンコードするときに数字の桁数を指定する"
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

SwiftでJSONデコードするときに数字の桁数を指定する方法です。
文字列になってしまいましたが、以下のように encode メソッドを書くことで桁数を指定します。

```swift
import Foundation

struct MyStruct: Encodable {
    let number: Double

    enum CodingKeys: String, CodingKey {
        case number
    }

    func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(String(format: "%05f", number), forKey: .number)
    }
}

let myStruct = MyStruct(number: 1.0 / 3.0)
let data = try! JSONEncoder().encode(myStruct)
print(String(data: data, encoding: String.Encoding.utf8)!)
```

```swift
{"number":"0.333333"}
```
