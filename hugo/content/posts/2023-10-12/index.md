+++
title = "SwiftUIでNavigationViewの戻るボタンを非表示にする"
url = "2023-10-12"
date = "2023-10-12"
description = "SwiftUIでNavigationViewの戻るボタンを非表示にする"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIでNavigationViewの戻るボタンを非表示にする方法です。
`navigationBarBackButtonHidden` を false にすることで非表示にすることができます。

<img src="1.gif" width="300px" alt="SwiftUIでNavigationViewの戻るボタンを非表示にする">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    let fruits = ["Apple", "Banana", "Orange", "Grape", "Cherry", "Peach"]

    var body: some View {
        NavigationView {
            List(fruits, id: \.self) { fruit in
                NavigationLink(destination: SecondView(fruit: fruit)) {
                    Text(fruit)
                }
            }
        }
    }
}
```


**SecondView.swift**

```swift
import SwiftUI

struct SecondView: View {
    let fruit: String

    var body: some View {
        Text(fruit)
            .navigationBarBackButtonHidden(true)
    }
}
```

