+++
title = "UIScrollViewで画像をピンチで拡大したり縮小する"
url = "2017-11-13"
date = "2017-11-13"
description = "UIScrollViewで画像をピンチで拡大したり縮小する"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS"]
archives = "2017/13"
+++

<br>

UIScrollViewの中にある画像を拡大したり縮小するサンプルです。  
ピンチで画像を大きくしたり、小さくします。  

![alt](1.png)
![alt](2.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController, UIScrollViewDelegate {
    
    var scrollView: UIScrollView!
    var imageView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        scrollView = UIScrollView()
        scrollView.frame = self.view.frame
        scrollView.delegate = self
        scrollView.maximumZoomScale = 3.0
        scrollView.minimumZoomScale = 1.0
        self.view.addSubview(scrollView)
        
        imageView = UIImageView()
        imageView.image = UIImage(named: "snorlax")
        imageView.frame = scrollView.frame
        scrollView.addSubview(imageView)
    }
    
    func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return self.imageView
    }
}
```

