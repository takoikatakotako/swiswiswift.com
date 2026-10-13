+++
title =  "Identifiableに適合していないStructでListを使う"
url = "2021-07-02"
date = "2021-07-02"
description = "Identifiableに適合していないStructでListを使う"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2021/07"
+++

<br>

Identifiableに適合していないStructでListを使う方法です。
`id` でプロパティユニークとなるプロパティを指定することで `List` で使うことができます。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct Pokemon {
    let name: String
    let type: String
}

struct ContentView: View {
    let pokemons = [Pokemon(name: "Snorlax", type: "Normal"), Pokemon(name: "Eevee", type: "Normal")]
    var body: some View {
        List(pokemons, id: \.name) { pokemon in
            Text(pokemon.name)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```

