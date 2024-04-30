+++
title = "SwiftUIでシートを出し分ける"
url = "2023-11-12"
date = "2023-11-12"
description = "SwiftUIでシートを出し分ける"
tags = [
  "SwiftUI"
]
categories = [
  "SwiftUI"
]
archives = "2024/01"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftUIでPreviewを横向きにする方法です。

<img src="1.png" width="300px" alt="SwiftUIでPreviewを横向きにする">


TODO: 
{{< gist takoikatakotako cd108d941788af118601acab68557118 >}}


```swift
import SwiftUI

struct ContentView: View {
    @State var showingSnorlaxView = false
    @State var showingSlowpokeView = false
    
    var body: some View {
        VStack {
            Button(action: {
                showingSnorlaxView = true
            }) {
                Text("Show Snorlax")
            }
            
            Button(action: {
                showingSlowpokeView = true
            }) {
                Text("Show Slowpoke")
            }
        }
        .sheet(isPresented: $showingSnorlaxView) {
            SnorlaxView()
        }
        .sheet(isPresented: $showingSlowpokeView) {
            SlowpokeView()
        }
    }
}

#Preview {
    ContentView()
}
```