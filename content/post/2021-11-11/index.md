+++
title =  "Rustでコマンドライン引数を渡す"
url = "2021-11-11"
date = "2021-11-11"
description = "Rustでコマンドライン引数を渡す"
tags = [
  "Rust"
]
categories = [
  "Rust"
]
archives = "2021/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

Rustでコマンドライン引数を渡す方法です。

```Rust
use std::env;

fn main() {
    let args: Vec<String> = env::args().collect();
    println!("{:?}", args);
}
```

```bash
rustc main.rs
./main snorlax 143
```

```
["./main", "snorlax", "143"]
```
