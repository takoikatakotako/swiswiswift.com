+++
title = "列挙型 enum"
url = "2018-03-04"
date = "2018-03-04"
description = "列挙型 enum"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2018/03"
+++

<br>

列挙型、enumの書き方のサンプルコードです。  
ここではpersonというクラスを作り、カビゴンさんの名前と出身地をenumを用いて登録しています。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**enum.swift**

```swift
import UIKit

enum Country {
    case japan
    case america
    case kanada
    case china
}

class person: NSObject {
    var name:String!
    var from:Country!
}

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let kabigon = person()
        kabigon.name = "カビゴン"
        kabigon.from = Country.america
        
        switch kabigon.from {
        case .japan:
            print(kabigon.name + "は日本から来ました。")
        case .america:
            print(kabigon.name + "はアメリカから来ました。")
        case .kanada:
            print(kabigon.name + "はカナダから来ました。")
        case .china:
            print(kabigon.name + "は中国から来ました。")
        default:
            print("error")
        }
    }
}
```

