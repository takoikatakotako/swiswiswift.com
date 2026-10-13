+++
title =  "QGridを使ってCollectionViewを実装する"
url = "2021-03-01"
date = "2021-03-01"
description = "QGridを使ってCollectionViewを実装する"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/03"
+++

<br>

QGridを使ってCollectionViewを実装する方法です。
iOS13のSwiftUIではCollectionViewに相当するものがありません。
[QGrid](https://github.com/Q-Mobile/QGrid)を使うことでCollectionViewに似たものを実装することができます。

![QGrid](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI
import QGrid

struct ContentView: View {
    @State var people: [Pokemon] = [
        Pokemon(name: "Pikachu", imageName: "pikachu"),
        Pokemon(name: "Slowpoke", imageName: "slowpoke"),
        Pokemon(name: "Bellsprout", imageName: "bellsprout"),
        Pokemon(name: "Ditto", imageName: "ditto"),
        Pokemon(name: "Snorlax", imageName: "snorlax"),
        Pokemon(name: "Eevee", imageName: "eevee"),
        Pokemon(name: "Magikarp", imageName: "magikarp"),
    ]
    var body: some View {
        QGrid(people, columns: 2) { GridCell(person: $0) }
            .ignoresSafeArea()
    }
}

struct Pokemon: Identifiable {
    var id: String {
        return imageName
    }
    let name: String
    let imageName: String
}

struct GridCell: View {
    var person: Pokemon
    var body: some View {
        VStack() {
            Image(person.imageName)
                .resizable()
                .scaledToFit()
                .shadow(color: .primary, radius: 6)
                .padding([.horizontal, .top], 6)
            Text(person.name).lineLimit(1)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

```


