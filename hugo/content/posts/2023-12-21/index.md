+++
title = "SwiftUIでインディケーターを表示する"
url = "2023-12-21"
date = "2023-12-21"
description = "SwiftUIでインディケーターを表示する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/12"
+++

<br>

SwiftUIでインディケーターを表示する方法です。

<img src="2023-12-21.gif" width="300px" alt="SwiftUIでインディケーターを表示する">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var showingIndicator = true
    
    var body: some View {
        ZStack {
            VStack {
                Spacer()
                Button {
                    showingIndicator.toggle()
                } label: {
                    Text("Show or Hide Indicator")
                        .foregroundColor(Color.white)
                        .padding()
                        .background(Color.gray)
                        .clipped()
                }
            }
            
            if showingIndicator {
                ProgressView()
            }
        }
    }
}
```

