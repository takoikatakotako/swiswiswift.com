+++
title =  "RustでHelloWorldをする"
url = "2021-11-10"
date = "2021-11-10"
description = "RustでHelloWorldをする"
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

RustでHelloWorldをする方法です。
`main.rs` というファイルを作成します。

```Rust
fn main() {
    println!("Hello, World");
}
```

以下のコマンドでコンパイルします。

```bash
rustc main.rs
```

コンパイルすると `main` というファイルが出るので実行すると `Hello, World` と表示されます。

```bash
./main
```

```
Hello, World
```
