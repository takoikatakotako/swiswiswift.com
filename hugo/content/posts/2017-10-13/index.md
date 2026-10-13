+++
title = "○秒後に実行させる、毎秒実行する"
url = "2017-10-13"
date = "2017-10-13"
description = "○秒後に実行させる、毎秒実行する"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/10"
+++

<br>

Swiftで数秒後に実行する、毎秒実行させるサンプルです。  
一秒ごとにコンソールに出力されます。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**EverySecond.swift**

```swift
for i in 0..<100 {
  DispatchQueue.main.asyncAfter(deadline: .now() + 1.5*Double(i)) {
    print(i)
  }
}
```

