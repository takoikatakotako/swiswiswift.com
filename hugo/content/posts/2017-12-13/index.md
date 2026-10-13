+++
title = "一定時間で繰り返しを行う"
url = "2017-12-13"
date = "2017-12-13"
description = "一定時間で繰り返しを行う"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/12"
+++

<br>

Timeを使って3秒ごとに繰り返しを行います。  
時計のような機能を持つアプリを作る時に使いました。


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController {
    
    var timer: Timer!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
        //3秒ごとに繰り返す、repeat every 3 seconds
        timer = Timer.scheduledTimer(timeInterval: 3.0, target: self, selector: #selector(self.update), userInfo: nil, repeats: true)
        timer.fire()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        timer.invalidate()
    }
    
    @objc func update(tm: Timer) {
        //この関数を繰り返す、repeat this function
        print("Hello SwiSwiSwift")
    }
}
```

