+++
title = "数字を三桁ごとにカンマ区切りにする(日本円の表示)"
url = "2018-04-23"
date = "2018-04-23"
description = "数字を三桁ごとにカンマ区切りにする(日本円の表示)"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2018/04"
+++

<br>

日本円を表示するときのように3桁ごと,で区切る方法を調べてみました。  
`123,456,789円` みたいな感じです。  

参考に指せて頂いた記事  
[[Swift]数字を三桁ごとにカンマ区切りにする](https://qiita.com/ktanaka117/items/57c43c897fb7040e0980)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**UIViewController.swift**

```swift
import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        print(addComma(num: 123456789) + "円") //->123,456,789円
    }

    func addComma(num:NSInteger) -> String {
        let formatter = NumberFormatter()
        formatter.numberStyle = NumberFormatter.Style.decimal
        formatter.groupingSeparator = ","
        formatter.groupingSize = 3
        
        let numnum = NSNumber(value: num)
        let str = formatter.string(from: numnum)!
        return str
    }
}
```

