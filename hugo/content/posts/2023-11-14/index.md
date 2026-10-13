+++
title = "SwiftUIでAppStorageを使ってUserDefaultの値を監視する"
url = "2023-11-14"
date = "2023-11-14"
description = "SwiftUIでAppStorageを使ってUserDefaultの値を監視する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/11"
+++

<br>

SwiftUIでAppStorageを使ってUserDefaultの値を監視する方法です。

<img src="2023-11-14.gif" width="300px" alt="SwiftUIでAppStorageを使ってUserDefaultの値を監視する">

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @AppStorage("FAVORITE_POKEMON_NAME") var favoritePokemonName: String = ""

    var body: some View {
        VStack(spacing: 16) {
            Text("Your favorite pokemon is, \(favoritePokemonName)")

            Button("Snorlax is my mavorite pokemon.") {
                favoritePokemonName = "Snorlax"
            }

            Button("Slowpoke is my mavorite pokemon.") {
                UserDefaults.standard.set("Slowpoke", forKey: "FAVORITE_POKEMON_NAME")
            }
        }
    }
}

#Preview {
    ContentView()
}
```

