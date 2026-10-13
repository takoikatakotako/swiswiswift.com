+++
title =  "タップでセクション区切りのListViewにチェックを入れる"
url = "2020-02-18"
date = "2020-02-18"
description = "タップでセクション区切りのListViewにチェックを入れる"
tags = ["Swift", "SwiftUI"]
categories = ["Swift"]
archives = "2020/02"
+++

<br>

タップでセクション区切りのListViewにチェックを入れるサンプルです。
タップすることで State が変化し、✔︎を描画するようになります。

![CheckList](1.gif)


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var foodTypes: [FoodType] = [
        FoodType(
            name: "Meat",
            foods: [
                Food(check: true, name: "Beef"),
                Food(check: true, name: "Pork"),
                Food(check: true, name: "Chicken"),
                Food(check: true, name: "Mutton"),
                Food(check: true, name: "Venison"),
            ]
        ),
        FoodType(
            name: "Fish",
            foods: [
                Food(check: true, name: "Tuna"),
                Food(check: true, name: "Mackerel"),
                Food(check: true, name: "Salmon"),
                Food(check: true, name: "Shark"),
                Food(check: true, name: "Bonito"),
                Food(check: true, name: "Monkfish"),
                Food(check: true, name: "Sardine"),
                Food(check: true, name: "Moray"),
                Food(check: true, name: "Eel"),
                Food(check: true, name: "Ray"),
            ]
        ),
        FoodType(
            name: "Fruit",
            foods: [
                Food(check: true, name: "Apple"),
                Food(check: true, name: "Banana"),
                Food(check: true, name: "Orange"),
                Food(check: true, name: "Peach"),
            ]
        )
    ]
    
    var body: some View {
        List {
            ForEach(0 ..< self.foodTypes.count) { foodTypeIndex in
                Section(header: Text(self.foodTypes[foodTypeIndex].name)) {
                    ForEach(0 ..< self.foodTypes[foodTypeIndex].foods.count) { foodIndex in
                        Button(action: {
                            self.foodTypes[foodTypeIndex].foods[foodIndex].check.toggle()
                        }) {
                            ListRow(check: self.foodTypes[foodTypeIndex].foods[foodIndex].check, name: self.foodTypes[foodTypeIndex].foods[foodIndex].name)
                        }
                    }
                }
            }
        }
        .edgesIgnoringSafeArea([.bottom])
    }
}

struct FoodType: Identifiable, Equatable {
    let id: UUID = UUID()
    var name: String
    var foods: [Food]
}

struct Food: Identifiable, Equatable {
    let id: UUID = UUID()
    var check: Bool
    var name: String
}

struct ListRow: View {
    let check: Bool
    let name: String
    var body: some View {
        HStack {
            if check {
                Text("✔︎")
            } else {
                Text(" ")
            }
            Text(name)
            Spacer()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```

