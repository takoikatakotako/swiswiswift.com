+++
title =  "SwiftUIで画像をピンチで拡大する（PDFView）"
url = "2022-04-06"
date = "2022-04-06"
description = "SwiftUIで画像をピンチで拡大する（PDFView）"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2022/04"
+++

<br>

SwiftUIで画像をピンチで拡大する方法です。
画像をピンチで拡大します。

他にはこのような方法があります。

[SwiftUIで画像をピンチで拡大する（MagnificationGesture）](/2022-04-05)

[SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）](/2022-04-07)


参考: [Isn't there an easy way to pinch to zoom in an image in Swiftui?](https://stackoverflow.com/questions/58341820/isnt-there-an-easy-way-to-pinch-to-zoom-in-an-image-in-swiftui)

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
    var body: some View {
        PhotoDetailView(image: UIImage(named: "icon")!)
    }
}
```


**PhotoDetailView.swift**

```swift
import SwiftUI
import PDFKit

struct PhotoDetailView: UIViewRepresentable {
    let image: UIImage

    func makeUIView(context: Context) -> PDFView {
        let view = PDFView()
        view.document = PDFDocument()
        guard let page = PDFPage(image: image) else { return view }
        view.document?.insert(page, at: 0)
        view.autoScales = true
        return view
    }

    func updateUIView(_ uiView: PDFView, context: Context) {}
}
```


