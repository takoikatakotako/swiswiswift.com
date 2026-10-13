+++
title =  "RustでstructをJSONにシリアライズしたりデシリアライズする"
url = "2021-11-14"
date = "2021-11-14"
description = "RustでstructをJSONにシリアライズしたりデシリアライズする"
tags = ["Rust"]
categories = ["Rust"]
archives = "2021/11"
+++

<br>

RustでstructをJSONにシリアライズしたりデシリアライズする方法です。

[参考](https://serde.rs/derive.html)

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
    let pokemon = Pokemon { id: 143, name: String::from("Snorlax") };

    let serialized = serde_json::to_string(&pokemon).unwrap();
    println!("serialized = {}", serialized);

    let deserialized: Pokemon = serde_json::from_str(&serialized).unwrap();
    println!("deserialized = {:?}", deserialized);
}
```


