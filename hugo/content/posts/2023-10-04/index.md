+++
title = "SwiftUIで画像を丸く切り取り枠を付ける"
url = "2023-10-04"
date = "2023-10-04"
description = "SwiftUIで画像を丸く切り取り枠を付ける"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIで画像を丸く切り取り枠を付ける方法です。
150×200サイズに画像をリサイズして表示させています。
アスペクト比が異なる場合ははみ出た箇所を切り取って表示しています。

<img src="1.png" width="300px" alt="SwiftUIで画像を丸く切り取り枠を付ける">

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

