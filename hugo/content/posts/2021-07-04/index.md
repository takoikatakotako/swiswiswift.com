+++
title =  "複数の型を持つJSONをemumでDecodeする"
url = "2021-07-04"
date = "2021-07-04"
description = "複数の型を持つJSONをemumでDecodeする"
tags = ["Swift"]
categories = ["Swift"]
archives = "2021/07"
+++

<br>

複数の型を持つ JSON を enum を使って Decode する方法です。
とある API を叩くと JSON が返ってきますが、その中身がポケモンなのかトレーナーなのかジムリーダーなのかわかりません。
以下のコードのように enum の Character の中に Pokemon, GymLeader, Trainer を定義することで、どのような JSON が来ても Decode できるようになります。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**Main.swift**

```swift
import Foundation

struct Pokemon: Codable {
    let id: Int
    let name: String
}

struct GymLeader: Codable {
    let name: String
    let badge: String
    let pokemons: [Pokemon]
}

struct Trainer: Codable {
    let name: String
    let pokemons: [Pokemon]
}

enum Character: Codable {
    case pokemon(Pokemon)
    case gymLeader(GymLeader)
    case trainer(Trainer)
    
    init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let pokemon = try? container.decode(Pokemon.self) {
            self = .pokemon(pokemon)
            return
        }
        
        if let gymLeader = try? container.decode(GymLeader.self) {
            self = .gymLeader(gymLeader)
            return
        }
        
        if let trainer = try? container.decode(Trainer.self) {
            self = .trainer(trainer)
            return
        }
        throw CharacterError.failToDecode
    }
    
    func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .pokemon(pokemon):
            try container.encode(pokemon)
        case let .gymLeader(gymLeader):
            try container.encode(gymLeader)
        case let .trainer(trainer):
            try container.encode(trainer)
        }
    }
}

enum CharacterError: LocalizedError {
    case failToDecode
    
    var errorDescription: String? {
        switch self {
        case .failToDecode:
            return "Fail to Decode"
        }
    }
}

let pokemonData = """
{
 "id": 143,
 "name": "Snorlax"
}
""".data(using: .utf8)!

let pokemon = try! JSONDecoder().decode(Character.self, from: pokemonData)
print(pokemon)


let gymLeaderData = """
{
 "name": "Brock",
 "badge": "Gray Badge",
 "pokemons": [
    {
      "id": 95,
      "name": "Onix"
    }
  ]
}
""".data(using: .utf8)!

let gymLeader = try! JSONDecoder().decode(Character.self, from: gymLeaderData)
print(gymLeader)


let trainerData = """
{
 "name": "Super Nerd",
 "pokemons": [
    {
      "id": 81,
      "name": "Magnemite"
    }
  ]
}
""".data(using: .utf8)!

let trainer = try! JSONDecoder().decode(Character.self, from: trainerData)
print(trainer)


let errorData = """
{
 "name": "Error"
}
""".data(using: .utf8)!

do {
    _ = try JSONDecoder().decode(Character.self, from: errorData)
} catch {
    print(error.localizedDescription)
}
```

