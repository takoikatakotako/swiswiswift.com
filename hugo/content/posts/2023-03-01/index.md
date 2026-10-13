+++
title = "SwiftでJSONをDictonaryでDecodeする"
url = "2023-03-01"
date = "2023-03-01"
description = "SwiftでJSONをDictonaryでDecodeする"
tags = ["Swift"]
categories = ["Swift"]
archives = "2023/03"
+++

<br>

SwiftでJSONをDictonaryでDecodeする方法です。
Mapのような辞書配列をDictionaryのプロパティを持つstructでDecodeしています。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Playground.swift**

```swift
let json = """
{
  "expressions":{
    "confused":{
      "images":[
        "confused1.png"
      ],
      "voices":[
        "confused1.mp3",
        "confused2.mp3"
      ]
    },
    "normal":{
      "images":[
        "normal.png"
      ],
      "voices":[
        "normal1.mp3",
        "normal2.mp3"
      ]
    },
    "smile":{
      "images":[
        "smile.png"
      ],
      "voices":[
        "smile.mp3",
        "smile.mp3"
      ]
    }
  }
}
""".data(using: .utf8)!

struct Response: Decodable {
    let expressions: [String: Expression]
}

struct Expression: Decodable {
    let images: [String]
    let voices: [String]
}

let response = try! JSONDecoder().decode(Response.self, from: json)
print(response)
```

