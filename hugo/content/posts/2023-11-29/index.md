+++
title = "SwiftUIでSearchBar(TextField)を使って検索する"
url = "2023-11-29"
date = "2023-11-29"
description = "SwiftUIでSearchBar(TextField)を使って検索する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/11"
+++

<br>

SwiftUIでPreviewを横向きにする方法です。

<img src="2023-11-29.gif" width="300px" alt="SwiftUIでSearchBar(TextField)を使って検索する">

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

