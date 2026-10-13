+++
title = "SwiftUIでdelegateを使用する"
url = "2023-12-12"
date = "2023-12-12"
description = "SwiftUIでdelegateを使用する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/12"
+++

<br>

SwiftUIでdelegateを使用する方法です。

<img src="2023-12-12.gif" width="300px" alt="SwiftUIでdelegateを使用する">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View, MyProtocol {
    @State var text: String = "My Text"
    var body: some View {
        NavigationView {
            VStack {
                Text(text)
                NavigationLink(destination: SecondView(delegate: self)) {
                    Text("2nd View")
                }
            }
        }
    }

    func myFunc() {
        text = "Changed Text"
    }
}
```


**SecondView.swift**

```swift
import SwiftUI

protocol MyProtocol {
    func myFunc()
}

struct SecondView: View {
    var delegate: MyProtocol
    var body: some View {
        Button(action: {
            self.delegate.myFunc()
        }) {
            Text("ChangeText")
        }
    }
}
```

