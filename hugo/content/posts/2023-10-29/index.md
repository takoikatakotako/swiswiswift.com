+++
title = "SwiftUIで全画面でSheetを表示する"
url = "2023-10-29"
date = "2023-10-29"
description = "SwiftUIで全画面でSheetを表示する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIで全画面でSheetを表示する方法です。

<img src="2023-10-29.gif" width="300px" alt="SwiftUIで全画面でSheetを表示する">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var showingCover = false
    var body: some View {
        VStack {
            Button(action: {
                showingCover = true
            }) {
                Text("Tap me!")
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.gray)
        .fullScreenCover(isPresented: $showingCover) {
            SecondView()
        }
    }
}

#Preview {
    ContentView()
}
```


**SecondView.swift**

```swift
import SwiftUI

struct SecondView: View {
    @Environment(\.dismiss) var dismiss

    var body: some View {
        VStack {
            Button(action: {
                dismiss()
            }) {
                Text("Dismiss")
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.white)
    }
}

#Preview {
    SecondView()
}
```

