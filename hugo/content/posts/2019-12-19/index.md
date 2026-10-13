+++
title =  "Swift5.1で追加されたFunctionBuilderを使ってStructを作る"
url = "2019-12-19"
date = "2019-12-19"
description = "Swift5.1で追加されたFunctionBuilderを使ってStructを作る"
tags = ["Swift"]
categories = ["Swift"]
archives = "2019/12"
+++

<br>

Swift5.1で追加されたFunctionBuilderを使ってStructを作る方法です。
SwiftUI でも活躍していますね。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**FunctionBuilder.swift**

```swift
public struct Company: CustomStringConvertible {
    let name: String
    let president: String
    let numberOfEmployees: Int
    let adress: String
    
    public var description: String {
        return "name: \(name), president: \(president), numberOfEmployees: \(numberOfEmployees), adress: \(adress)"
    }
}

@_functionBuilder public struct CompanyBuilder {
    public static func buildBlock(_ name: String, _ president: String, _ numberOfEmployees: Int, _ adress: String) -> Company {
        Company(name: name, president: president, numberOfEmployees: numberOfEmployees, adress: adress)
    }
}

@CompanyBuilder
func myFunc() -> Company {
    "株式会社すいすいSwift"
    "カビゴン小野"
    1
    "神奈川"
}

let company = myFunc()
print(company.description)
```

