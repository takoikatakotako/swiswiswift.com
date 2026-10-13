+++
title = "マークダウンのリンクの色を赤色に変える"
url = "2023-11-09"
date = "2023-11-09"
description = "マークダウンのリンクの色を赤色に変える"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/11"
+++

<br>

マークダウンのリンクの色を赤色に変える方法です。

<img src="2023-11-09.png" width="300px" alt="マークダウンのリンクの色を赤色に変える">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    let markdownText: String = "**Snorlax** is the **most** cute pokemon!\n[About Snorlax](https://en.wikipedia.org/wiki/Snorlax)"

    var body: some View {
        Text(LocalizedStringKey(markdownText))
            .tint(Color.red)
    }
}

#Preview {
    ContentView()
}
```

