+++
title =  "SwiftUIでText中の文字の太さや色を変える"
url = "2020-06-22"
date = "2020-06-22"
description = "SwiftUIでText中の文字の太さや色を変える"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/06"
+++

<br>

SwiftUIでText中の文字の太さや色を変える方法です。
SwiftUI で Text を結合できるのが面白いです。

![Text Color and Change Font](1.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        (Text("I ")
            + Text("love ")
                .foregroundColor(Color.red)
            + Text("Snorlax")
                .foregroundColor(Color.black)
                .font(Font.system(size: 20).bold())
            
            + Text("!\n")
            + Text("Snorlax is most cute & cool& powerful Pokemon.")
            ).lineSpacing(4)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .previewLayout(.sizeThatFits)
    }
}
```

