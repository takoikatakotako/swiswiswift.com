+++
title =  "SwiftUIでフルスクリーンモーダルを表示する（iOS14以上）"
url = "2021-02-02"
date = "2021-02-02"
description = "SwiftUIでフルスクリーンモーダルを表示する（iOS14以上）"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/02"
+++

<br>

SwiftUIでフルスクリーンモーダルを表示する方法です。（iOS14以上）
いままでSwiftUIでフルスクリーンのモーダルを表示するのは大変でしたが、iOS14からはこの方法で表示することができるようになります。お手軽ですね。

![ShowModal](1.gif)

iOS13でフルスクリーンモーダルを表示させたい場合はこの記事をご参照ください。

[SwiftUIでフルスクリーンモーダルを表示する](/2020-05-05/)

参考: [How to present a full screen modal view using fullScreenCover()](https://www.hackingwithswift.com/quick-start/swiftui/how-to-present-a-full-screen-modal-view-using-fullscreencover)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State private var showingModal = false
    
    var body: some View {
        Button("Show Modal") {
            showingModal = true
        }
        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity)
        .background(Color(UIColor.lightGray))
        .edgesIgnoringSafeArea(.all)
        .fullScreenCover(isPresented: $showingModal, content: FullScreenModalView.init)
    }
}

struct FullScreenModalView: View {
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        Button("Dismiss Modal") {
            presentationMode.wrappedValue.dismiss()
        }
        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity)
        .background(Color.white)
        .edgesIgnoringSafeArea(.all)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```

