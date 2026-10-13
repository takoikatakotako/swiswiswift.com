+++
title = "SwiftでURLが入ったJSONをデコードする"
url = "2023-06-03"
date = "2023-06-03"
description = "SwiftでURLが入ったJSONをデコードする"
tags = ["Swift"]
categories = ["Swift"]
archives = "2023/06"
+++

<br>

SwiftでURLが入ったJSONをデコードする方法です。
普通にデコードするだけで URL型にすることができました。


<!--more-->

**Playground.swift**

```swift
import UIKit

let json = """
{
  "fileURL": "https://swiswiswift.com/"
}
""".data(using: .utf8)!

struct Response: Decodable {
    let fileURL: URL
}

let response = try! JSONDecoder().decode(Response.self, from: json)
print(response)
```

