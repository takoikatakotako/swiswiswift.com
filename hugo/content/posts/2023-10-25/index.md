+++
title = "SwiftUIで画面遷移先のViewから遷移元のメソッドを呼び出す"
url = "2023-10-25"
date = "2023-10-25"
description = "SwiftUIで画面遷移先のViewから遷移元のメソッドを呼び出す"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIで画面遷移先のViewから遷移元のメソッドを呼び出す方法です。

<img src="1.gif" width="300px" alt="SwiftUIで画面遷移先のViewから遷移元のメソッドを呼び出す">

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


**MyProtocol.swift**

```swift
import Foundation

protocol MyProtocol {
    func myFunc()
}
```


**SecondView.swift**

```swift
import SwiftUI

struct SecondView: View {
    var delegate: MyProtocol
    var body: some View {
        Button(action: {
            delegate.myFunc()
        }) {
            Text("ChangeText")
        }
    }
}
```

