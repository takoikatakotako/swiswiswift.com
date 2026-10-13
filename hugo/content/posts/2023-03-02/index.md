+++
title = "SwiftUIでImageの色を反転させる"
url = "2023-03-02"
date = "2023-03-02"
description = "SwiftUIでImageの色を反転させる"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/03"
+++

<br>

SwiftUIでImageの色を反転させる方法です。
`.colorInvert()` を追加することで色を反転させることができます。
[SDWebImage/SDWebImageSwiftUI](https://github.com/SDWebImage/SDWebImageSwiftUI)

{{< figure src="20230302.png" width="400" >}}

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
        VStack {
            Image("snorlax")
                .colorInvert()
        }
    }
}
```

