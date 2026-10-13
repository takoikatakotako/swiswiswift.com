+++
title =  "Swiftで仮引数を持つイニシャライザをスマートに書く"
url = "2020-08-09"
date = "2020-08-09"
description = "Swiftで仮引数を持つイニシャライザをスマートに書く"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2020/08"
+++

<br>

Swiftで仮引数を持つイニシャライザをスマートに書く方法です。
仮引数がついたイニシャライザをもち、イニシャライズ時の値を定数として保持する Struct を作る時、<code>private(set) var name = "snorlax"</code> を使うと短くスマートに書くことができます。
プロパティが増えてもイニシャライザを編集する必要が無くなります。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Playground.swift**

```swift
import Foundation

struct Pokemon {
    let name: String

    init(name: String = "snorlax") {
        self.name = name
    }
}

struct Pokemon {
    private(set) var name = "snorlax"
}

let pokemon = Pokemon(name: "slowpoke")
// Cannot assign to property: 'name' setter is inaccessible
// pokemon.name = "snorlax"
print(pokemon.name)
```

