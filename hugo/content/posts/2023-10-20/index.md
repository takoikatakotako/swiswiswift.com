+++
title = "SwiftUIでText中の文字の太さや色を変える"
url = "2023-10-20"
date = "2023-10-20"
description = "SwiftUIでText中の文字の太さや色を変える"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIで画像を丸く切り取り枠を付ける方法です。
150×200サイズに画像をリサイズして表示させています。
アスペクト比が異なる場合ははみ出た箇所を切り取って表示しています。

<img src="1.png" width="300px" alt="SwiftUIでText中の文字の太さや色を変える">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Text("I")
                .font(.system(size: 20).bold())
            + Text(" ❤️ ")
                .foregroundStyle(Color.red)
            + Text("Snorlax")
                .foregroundStyle(Color.black)
                .font(.system(size: 20).bold())
            + Text("!\n")
            + Text("Snorlax ")
                .foregroundStyle(Color.red)
                .font(.system(size: 20).bold())
            + Text("is most ")
                .foregroundStyle(Color.blue)
                .font(.system(size: 20).bold())
            + Text("cute & cool& powerful .")
                .foregroundStyle(Color.green)
                .font(.system(size: 20).bold())
            + Text("Pokemon.")
                .foregroundStyle(Color.yellow)
                .font(.system(size: 20).bold())
        }
    }
}
```

