+++
title =  "RustでキャメルケースのJSONをスネークケースにデシリアライズしたり、キャメルケースのJSONにする"
url = "2021-12-04"
date = "2021-12-04"
description = "RustでキャメルケースのJSONをスネークケースにデシリアライズしたり、キャメルケースのJSONにする"
tags = ["Rust"]
categories = ["Rust"]
archives = "2021/12"
+++

<br>

RustでキャメルケースのJSONをスネークケースにデシリアライズしたり、キャメルケースのJSONにする方法です。
JSONはキャメルケース、Rustはスネークケースは多いので重宝します。

[参考](https://serde.rs/field-attrs.html)

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**Cargo.toml**

```toml
[package]
name = "swiswiswift"
version = "0.1.0"
edition = "2018"

[dependencies]
serde = { version = "1.0", features = ["derive"] }
serde_json = "1.0"
```


**main.rs**

```rust
use serde::{Serialize, Deserialize};

#[derive(Serialize, Deserialize, Debug)]
enum PokemonType {
    Normal,
    Fire,
    Water,
}

#[derive(Serialize, Deserialize, Debug)]
struct Pokemon {
    id: i32,
    name: String,
    #[serde(rename(serialize = "pokemonType", deserialize = "pokemonType"))]
    pokemon_type: PokemonType,
}

fn main() {
    let pokemon = Pokemon { id: 143, name: String::from("Snorlax"), pokemon_type: PokemonType::Normal };

    let serialized = serde_json::to_string(&pokemon).unwrap();
    println!("serialized = {}", serialized);

    let deserialized: Pokemon = serde_json::from_str(&serialized).unwrap();
    println!("deserialized = {:?}", deserialized);
}
```


