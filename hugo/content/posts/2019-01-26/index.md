+++
title = "SwiftでUITestを導入(Swift4.2)"
url = "2019-01-26"
date = "2019-01-26"
description = "SwiftでUITestを導入(Swift4.2)"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2019/01"
+++

<br>

プロジェクトにUITestを追加します。  
プロジェクト作成時に作らなかった場合は以下の画像の手順で追加することができます。



`@testable import Swiswiswift`（Swiswiswiftはプロジェクト名）　と書くことで、テストクラスの中から参照できるようになります。  
関数名の頭にtestと付けることで、テストとして実行できるようになります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**FizzBuzzTests_20190127.swift**

```swift
import XCTest

@testable import Swiswiswift

class FizzBuzzTests_20190127: XCTestCase {

    func testTreeMultiples() {
        for treeMultiples in [3, 6, 9, 12, 18] {
            let actual = FizzBuzz_20190127.fizzBuzz(num: treeMultiples)
            XCTAssertEqual(actual, "Fizz")
        }
    }

    func testFiveMultiples() {
        for fiveMultiples in [5, 10, 20, 25, 50] {
            let actual = FizzBuzz_20190127.fizzBuzz(num: fiveMultiples)
            XCTAssertEqual(actual, "Buzz")
        }
    }

    func testThreeAndFiveMultiples() {
        for testThreeAndFiveMultiples in [15, 30, 45, 60, 75] {
            let actual = FizzBuzz_20190127.fizzBuzz(num: testThreeAndFiveMultiples)
            XCTAssertEqual(actual, "FizzBuzz")
        }
    }
}
```


**FizzBuzz_20190127.swift**

```swift
import UIKit

class FizzBuzz_20190127 {

    class func fizzBuzz(num: Int) -> String {
        if num % 15 == 0 {
            return "FizzBuzz"
        } else if num % 3 == 0 {
            return "Fizz"
        } else if num % 5 == 0 {
            return "Buzz"
        } else {
            return "\(num)"
        }
    }
}
```

