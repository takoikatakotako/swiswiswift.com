+++
title = "UserDefaultsで複数の値をセットで保存する"
url = "2023-02-24"
date = "2023-02-24"
description = "UserDefaultsで複数の値をセットで保存する"
tags = ["Swift", "SwiftUI"]
categories = ["Swift"]
archives = "2023/02"
+++

<br>

UserDefaultsで複数の値をセットで保存する方法です。
辞書型配列を使う方法と保存用のstructを作成する方法でサンプルコードを作成しました。
Set ボタンを押すと UserDefaults にカビゴンの情報が保存され、Get ボタンを押すとカビゴンの情報をコンソールに出力します。

{{< figure src="20230224.png" width="400" >}}


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}


### 辞書型配列を使う方法

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Button {
                var snorlax: Dictionary<String, Any> = [:]
                snorlax["id"] = 143
                snorlax["name"] = "snorlax"
                snorlax["type"] = "normal"
                UserDefaults.standard.set(snorlax, forKey: "snorlax")
            } label: {
                Text("Set")
                    .font(.system(size: 28).bold())
                    .padding()
                    .border(.black)
                    .padding()
            }

            Button {
                if let snorlax = UserDefaults.standard.object(forKey: "snorlax") as? Dictionary<String, Any> {
                    print(snorlax["id"] as! Int)
                    print(snorlax["name"] as! String)
                    print(snorlax["type"] as! String)
                }
            } label: {
                Text("Get")
                    .font(.system(size: 28).bold())
                    .padding()
                    .border(.black)
                    .padding()
            }
        }
    }
}
```


### 保存用のstructを作成する方法

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Button {
                let snorlax: Pokemon = Pokemon(id: 143, name: "snorlax", type: "normal")
                let encoded: Data = try! JSONEncoder().encode(snorlax)
                UserDefaults.standard.set(encoded, forKey: "snorlax")
            } label: {
                Text("Set")
                    .font(.system(size: 28).bold())
                    .padding()
                    .border(.black)
                    .padding()
            }

            Button {
                if let encoded = UserDefaults.standard.object(forKey: "snorlax") as? Data,
                   let snorlax = try? JSONDecoder().decode(Pokemon.self, from: encoded) {
                   print(snorlax)
                }
            } label: {
                Text("Get")
                    .font(.system(size: 28).bold())
                    .padding()
                    .border(.black)
                    .padding()
            }
        }
    }
}
```


**Pokemon.swift**

```swift
import Foundation

struct Pokemon: Codable {
    let id: Int
    let name: String
    let type: String
}
```

