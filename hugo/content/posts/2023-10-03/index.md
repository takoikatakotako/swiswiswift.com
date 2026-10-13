+++
title = "SwiftUIで画像をリサイズして表示する（clip）"
url = "2023-10-03"
date = "2023-10-03"
description = "SwiftUIで画像をリサイズして表示する（clip）"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIで画像をリサイズして表示させる方法です。
150×200サイズに画像をリサイズして表示させています。
アスペクト比が異なる場合ははみ出た箇所を切り取って表示しています。

<img src="1.png" width="300px" alt="画像をリサイズして表示（clip）">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        Image(.icon)
            .resizable()
            .scaledToFill()
            .frame(width: 150, height: 200)
            .clipped()
            .background(Color.red)
    }
}

#Preview {
    ContentView()
}
```

