+++
title = "SwiftUIのListの中にボタンを複数設置する"
url = "2023-11-28"
date = "2023-11-28"
description = "SwiftUIのListの中にボタンを複数設置する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/11"
+++

<br>

SwiftUIのListの中にボタンを複数設置する方法です。

<img src="2023-11-28.png" width="300px" alt="SwiftUIのListの中にボタンを複数設置する">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    let pokemons: [String] = ["Snorlax", "Slowpoke", "Pikachu", "Eevee"]
    @State var text: String = ""
    var filterdPokemons: [String] {
        if text.isEmpty {
            return pokemons
        } else {
            return pokemons.filter {$0.uppercased().contains(text.uppercased())}
        }
    }
    var body: some View {
        ScrollView {
            LazyVStack {
                TextField("Type your search", text: $text)
                    .padding(8)
                    .textFieldStyle(RoundedBorderTextFieldStyle())
                ForEach(filterdPokemons, id: \.self) { pokemon in
                    VStack(alignment: .leading) {
                        Text(pokemon)
                            .padding(.leading, 12)
                        Divider()
                    }
                }
            }
        }
    }
}

#Preview {
    ContentView()
}
```

