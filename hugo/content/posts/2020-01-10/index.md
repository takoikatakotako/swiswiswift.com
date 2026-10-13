+++
title =  "Swiftで数字が連番になった配列を作成する"
url = "2020-01-10"
date = "2020-01-10"
description = "Swiftで数字が連番になった配列を作成する"
tags = ["Swift"]
categories = ["Swift"]
archives = "2020/01"
+++

<br>

Swiftで数字が連番になった配列を作成する方法です。
なかなか書き方を覚えられません。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**swift.playground**

```text
let hours: [Int] = Array(0..<24)
let minutes: [Int] = Array(0...59)

// hour: 0, 1, 2, ... 23
print(hours.count)  // 23

// minutes: 0, 1, 2, ...59
print(minutes.count)    // 60
```

