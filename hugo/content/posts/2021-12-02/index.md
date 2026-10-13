+++
title =  "RustでstructをJSONにシリアライズしてファイルに保存する"
url = "2021-12-02"
date = "2021-12-02"
description = "RustでstructをJSONにシリアライズしてファイルに保存する"
tags = ["Rust"]
categories = ["Rust"]
archives = "2021/12"
+++

<br>

RustでstructをJSONにシリアライズしてファイルに保存する方法です。
StringにしてJSONで保存しています。

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
use std::fs::File;
use std::io::prelude::*;

#[derive(Serialize, Deserialize, Debug)]
struct Pokemon {
    id: i32,
    name: String,
}

fn main() {
    let eevee = Pokemon { id: 133, name: String::from("Eevee") };
    let snorlax = Pokemon { id: 143, name: String::from("Snorlax") };

    let mut pokemons: Vec<Pokemon> = Vec::new();
    pokemons.push(eevee);
    pokemons.push(snorlax);

    let result = write_file(pokemons);
    match result {
        Ok(..) => { println!("Write Finished") }
        Err(err) => { println!("Failed to Write: {}", err) }
    }
}

fn write_file(pokemons: Vec<Pokemon>) -> std::io::Result<()> {
    // serialized
    let serialized: String = serde_json::to_string(&pokemons).unwrap();

    // write
    let mut file = File::create("output/pokemons.json")?;
    file.write_all(serialized.as_bytes())?;
    Ok(())
}
```


**pokemons.json**

```json
[{"id":133,"name":"Eevee"},{"id":143,"name":"Snorlax"}]
```


