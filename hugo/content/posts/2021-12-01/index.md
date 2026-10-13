+++
title =  "RustでJSONを読み込みVecにデシリアライズする"
url = "2021-12-01"
date = "2021-12-01"
description = "RustでJSONを読み込みVecにデシリアライズする"
tags = ["Rust"]
categories = ["Rust"]
archives = "2021/12"
+++

<br>

RustでJSONを読み込みVecにデシリアライズする方法です。
JSONを読み込んでVecに変換しています。

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
use std::fs;

#[derive(Serialize, Deserialize, Debug)]
struct Pokemon {
    id: i32,
    name: String,
}

fn main() {
    let content = fs::read_to_string("resource/pokemons.json")
        .expect("Failed to load JSON");
    let deserialized: Vec<Pokemon> = serde_json::from_str(&content).unwrap();
    println!("deserialized = {:?}", deserialized);
}
```


**pokemons.json**

```json
[
  {
    "id": 133,
    "name": "Eevee"
  },
  {
    "id": 143,
    "name": "Snorlax"
  }
]
```


