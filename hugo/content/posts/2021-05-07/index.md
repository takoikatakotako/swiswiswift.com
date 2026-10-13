+++
title =  "Swiftでデフォルト引数を使う"
url = "2021-05-07"
date = "2021-05-07"
description = "Swiftでデフォルト引数を使う"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2021/05"
+++

<br>

Swiftでデフォルト引数を使う方法です。
`favorite` 関数に引数を渡さず呼び出すと `"I love Snorlax` が返り、任意の名前を渡すとその値が使われます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Text(favorite())
            Text(favorite(name: "Slowpole"))
        }
    }
    
    func favorite(name: String = "Snorlax") -> String {
        return "I love \(name)"
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```


