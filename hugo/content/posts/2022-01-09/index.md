+++
title =  "Swiftで最低幅を持ち横幅が可変なボタンを作成する"
url = "2022-01-09"
date = "2022-01-09"
description = "Swiftで最低幅を持ち横幅が可変なボタンを作成する"
tags = ["iOS", "Swift", "UIKit"]
categories = ["Swift", "UIKit"]
archives = "2022/01"
+++

<br>

Swiftで最低幅を持ち横幅が可変なボタンを作成する方法です。
ボタンの横幅が最低53pxで、余白が12px以上あるボタンを作成しています。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**VariableWidthButton.swift**

```swift
import UIKit

class VariableWidthButton: UIButton {
    func setTitleTextAndWidth(title: String) {
        backgroundColor = .lightGray
        setTitle(title, for: .normal)
        setTitleColor(.white, for: .normal)
        titleLabel?.font =  .systemFont(ofSize: 11)
        layer.cornerRadius = 12

        if let titleLabelSize = titleLabel?.intrinsicContentSize,
           titleLabelSize.width > (53 - 12) {
            frame.size = CGSize(width: titleLabelSize.width + 12, height: 24)
        } else {
            frame.size = CGSize(width: 53, height: 21)
        }
    }
}
```


**ViewController.swift**

```swift
import UIKit

class VariableWidthButton: UIButton {
    func setTitleTextAndWidth(title: String) {
        backgroundColor = .lightGray
        setTitle(title, for: .normal)
        setTitleColor(.white, for: .normal)
        titleLabel?.font =  .systemFont(ofSize: 11)
        layer.cornerRadius = 12

        if let titleLabelSize = titleLabel?.intrinsicContentSize,
           titleLabelSize.width > (53 - 12) {
            frame.size = CGSize(width: titleLabelSize.width + 12, height: 21)
        } else {
            frame.size = CGSize(width: 53, height: 21)
        }
    }
}
```


