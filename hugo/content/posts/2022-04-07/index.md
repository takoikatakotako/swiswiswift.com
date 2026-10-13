+++
title =  "SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）"
url = "2022-04-07"
date = "2022-04-07"
description = "SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2022/04"
+++

<br>

SwiftUIで画像をピンチで拡大する方法です。
UIImageViewとUIScrollViewを使って画像をピンチで拡大します。

他にはこのような方法があります。

[SwiftUIで画像をピンチで拡大する（MagnificationGesture）](/2022-04-05)

[SwiftUIで画像をピンチで拡大する（PDFView）](/2022-04-06)


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
        ImageViewer(imageName: "icon")
            .ignoresSafeArea(.all, edges: .all)
    }
}
```


**ImageViewer.swift**

```swift
import SwiftUI

struct ImageViewer: UIViewRepresentable {
    let imageName: String

    func makeUIView(context: Context) -> UIImageViewerView {
        let view = UIImageViewerView(imageName: imageName)
        return view
    }

    func updateUIView(_ uiView: UIImageViewerView, context: Context) {}
}

```


**UIImageViewerView.swift**

```swift
import UIKit

public class UIImageViewerView: UIView {
    private let imageName: String
    private let scrollView: UIScrollView = UIScrollView()
    private let imageView: UIImageView = UIImageView()
        
    required init(imageName: String) {
        self.imageName = imageName
        super.init(frame: .zero)
        
        scrollView.delegate = self
        scrollView.maximumZoomScale = 3.0
        scrollView.minimumZoomScale = 1.0
        // if you want to disable indicater
        // scrollView.showsHorizontalScrollIndicator = false
        // scrollView.showsVerticalScrollIndicator = false
        addSubview(scrollView)
                
        imageView.image = UIImage(named: imageName)
        imageView.contentMode = .scaleAspectFit
        scrollView.addSubview(imageView)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
    public override func layoutSubviews() {
       super.layoutSubviews()
        scrollView.frame = bounds
        imageView.frame = scrollView.frame
    }
}

extension UIImageViewerView: UIScrollViewDelegate {
    public func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return imageView
    }
}
```


