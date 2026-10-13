+++
title =  "SwiftUIでButtonを有効にしたり無効にしたりする"
url = "2021-03-04"
date = "2021-03-04"
description = "SwiftUIでButtonを有効にしたり無効にしたりする"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/03"
+++

<br>

SwiftUIでButtonを有効にしたり無効にしたりする方法です。
Toggleを押すとボタンが有効になったり、無効になったりします。

![Enable](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var enable: Bool = true
    var body: some View {
        VStack {
            Toggle(isOn: $enable) {
                Text("isEnable: \(enable.description)")
            }
            
            Button {
                print("Tapped!!")
            } label: {
                Text("Tap Me!!(\(enable ? "Enable": "Disable"))")
                    .foregroundColor(Color.white)
                    .padding()
                    .background(enable ? Color.orange: Color(UIColor.lightGray))
            }
            .disabled(!enable)
        }.padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

```


