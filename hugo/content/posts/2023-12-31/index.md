+++
title = "SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）"
url = "2023-12-31"
date = "2023-12-31"
description = "SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/12"
+++

<br>

SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）方法です。

<img src="2023-12-31.gif" width="300px" alt="SwiftUIで画像をピンチで拡大する（UIImageView + UIScrollView）">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        ImageViewerView(imageName: "icon")
            .ignoresSafeArea(.all, edges: .all)
    }
}

#Preview {
    ContentView()
}
```


**ImageViewerView.swift**

```swift
import SwiftUI

struct ImageViewerView: UIViewRepresentable {
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

