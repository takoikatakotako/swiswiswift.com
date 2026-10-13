+++
title = "SwiftUIで画像をピンチで拡大する（PDFView）"
url = "2023-12-30"
date = "2023-12-30"
description = "SwiftUIで画像をピンチで拡大する（PDFView）"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/10"
+++

<br>

SwiftUIで画像をピンチで拡大する（PDFView）方法です。

<img src="2023-12-30.gif" width="300px" alt="SwiftUIで画像をピンチで拡大する（PDFView）">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        ImageViewerView(image: UIImage(named: "icon")!)
    }
}

#Preview {
    ContentView()
}
```


**ImageViewerView.swift**

```swift
import SwiftUI
import PDFKit

struct ImageViewerView: UIViewRepresentable {
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

