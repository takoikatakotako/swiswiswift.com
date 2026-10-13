+++
title = "SwiftでUDP通信を行い、文字列を送る"
url = "2017-11-26"
date = "2017-11-26"
description = "SwiftでUDP通信を行い、文字列を送る"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/11"
+++

<br>

SwiftでUDP通信するメモです。  
[SwiftSocket](https://github.com/swiftsocket/SwiftSocket) をcocoapodsで入れて、こんな感じで書きました。  
woom-02と通信するのに使いました。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit
import SwiftSocket
class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        let client = UDPClient(address: "192.168.43.76", port: 12345)
        let data: Data = "kabigon-daisuiki".data(using: .utf8)!
        let result = client.send(data: data)
        print(result)
    }
}
```

