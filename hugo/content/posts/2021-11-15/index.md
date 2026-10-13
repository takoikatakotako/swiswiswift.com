+++
title =  "RustでJSONを読み込んでstructにデシリアライズする"
url = "2021-11-15"
date = "2021-11-15"
description = "RustでJSONを読み込んでstructにデシリアライズする"
tags = ["Rust"]
categories = ["Rust"]
archives = "2021/11"
+++

<br>

RustでJSONを読み込んでstructにデシリアライズする方法です。
ローカルのJSONを読み込んでstructに変換しています。

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
    let content = fs::read_to_string("resource/pokemon.json")
        .expect("Failed to load JSON");

    let pokemon: Pokemon = serde_json::from_str(&content).unwrap();
    println!("{:?}", pokemon);
}
```


**pokemon.json**

```json
{"id":143,"name":"Snorlax"}
```


