+++
title =  "Swiftで録画開始とスクリーンショットが取られたことを検知する"
url = "2020-06-15"
date = "2020-06-15"
description = "Swiftで録画開始とスクリーンショットが取られたことを検知する"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2020/06"
+++

<br>

Swiftで録画開始とスクリーンショットが取られたことを検知する方法です。
画面録画開始前に captureStatusDidChange を実行させることができるのですが、スクリーンショット撮影前に captureStatusDidChange を実行させることはできませんでした。
もしスクリーンショットを取られてしまっては不味いものがある場合、動画であれば DRM を使用したり、サードパーティーの [ScreenShieldKit](https://screenshieldkit.com/) を使用する必要があります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController {
    let password: String = "password"
    let passwordLabel = UILabel()
        
    override func viewDidLoad() {
        super.viewDidLoad()
        passwordLabel.textAlignment = .center
        passwordLabel.text = password
        passwordLabel.sizeToFit()
        passwordLabel.center = view.center
        view.addSubview(passwordLabel)
        
        // detect did take screenshot
        NotificationCenter.default.addObserver(
            self, selector: #selector(captureStatusDidChange),
            name: UIApplication.userDidTakeScreenshotNotification,
            object: nil
        )
        
        // detect record screen
        NotificationCenter.default.addObserver(
            self,
            selector: #selector(captureStatusDidChange),
            name: UIScreen.capturedDidChangeNotification,
            object: nil
        )
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        NotificationCenter.default.removeObserver(self)
    }
    
    @objc func captureStatusDidChange(){
        if UIScreen.main.isCaptured {
            passwordLabel.text = "************"
            passwordLabel.sizeToFit()
        } else {
            passwordLabel.text = password
            passwordLabel.sizeToFit()
        }
    }
}
```

