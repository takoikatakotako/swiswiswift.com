+++
title =  "RustでVecやArrayをシリアライズしたりデシリアライズする"
url = "2021-11-16"
date = "2021-11-16"
description = "RustでVecやArrayをシリアライズしたりデシリアライズする"
tags = ["Rust"]
categories = ["Rust"]
archives = "2021/11"
+++

<br>

RustでVecやArrayをシリアライズしたりデシリアライズする方法です。
VecでもArrayでもシリアライズ&デシリアライズすることができました。

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
struct Pokemon {
    id: i32,
    name: String,
}

fn main() {
    use_vec();
    use_array();
}

fn use_vec() {
    let eevee = Pokemon { id: 133, name: String::from("Eevee") };
    let snorlax = Pokemon { id: 143, name: String::from("Snorlax") };

    let mut pokemons: Vec<Pokemon> = Vec::new();
    pokemons.push(eevee);
    pokemons.push(snorlax);

    let serialized: String = serde_json::to_string(&pokemons).unwrap();
    println!("serialized = {}", serialized);

    let deserialized: Vec<Pokemon> = serde_json::from_str(&serialized).unwrap();
    println!("deserialized = {:?}", deserialized);
}

fn use_array() {
    let eevee = Pokemon { id: 133, name: String::from("Eevee") };
    let snorlax = Pokemon { id: 143, name: String::from("Snorlax") };

    let pokemons: [Pokemon; 2] = [eevee, snorlax];

    let serialized: String = serde_json::to_string(&pokemons).unwrap();
    println!("serialized = {}", serialized);

    let deserialized: [Pokemon; 2] = serde_json::from_str(&serialized).unwrap();
    println!("deserialized = {:?}", deserialized);
}
```


