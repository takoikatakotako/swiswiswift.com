+++
title =  "SwiftUIで画像をピンチで拡大する（MagnificationGesture）"
url = "2022-04-05"
date = "2022-04-05"
description = "SwiftUIで画像をピンチで拡大する（MagnificationGesture）"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2022/04"
+++

<br>

SwiftUIで画像をピンチで拡大する方法です。
MagnificationGestureを使った方法で画像をピンチで拡大します。
ただこの方法ではドラッグすることができないので、他の方法にする必要があります。

他にはこのような方法があります。

[SwiftUIで画像をピンチで拡大する（PDFView）](/2022-04-06)

[SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）](/2022-04-07)

![Pinch and Zoom](1.gif)


<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var scale: CGFloat = 1.0
    
    var body: some View {
        Image("icon")
            .resizable()
            .scaleEffect(scale)
            .frame(width: 200, height: 200)
            .gesture(MagnificationGesture()
                .onChanged { value in
                    scale = value.magnitude
                }
            )
    }
}
```


