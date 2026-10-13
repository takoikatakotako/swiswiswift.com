+++
title =  "SwiftUIでSearchBar(TextField)にクリアボタンをつける"
url = "2021-05-02"
date = "2021-05-02"
description = "SwiftUIでSearchBar(TextField)にクリアボタンをつける"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2021/05"
+++

<br>

SwiftUIでSearchBar(TextField)にクリアボタンをつける方法です。
TextFiled に文字を入力するとポケモンを検索します。
そして右側のボタンを押すと TextField がクリアされます。

![SwiftUIでSearchBar(TextField)にクリアボタンをつける](1.gif)

参考サイト
[SwiftUI: Add ClearButton to TextField](https://stackoverflow.com/questions/58200555/swiftui-add-clearbutton-to-textfield)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

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
            LazyVStack{
                TextField("Type your search",text: $text)
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

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```


