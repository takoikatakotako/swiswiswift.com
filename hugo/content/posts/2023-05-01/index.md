+++
title = "GolangでWebAPIを作るハンズオン（その１）"
url = "2023-05-01"
date = "2023-05-01"
description = "GolangでWebAPIを作るハンズオン（その１）"
tags = [
  "Golang"
]
categories = [
  "Golang"
]
archives = "2023/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

GolangでWebAPIを作るハンズオン（その１）です。

## 必要なもの

### Golang

公式の [Download and install](https://go.dev/doc/install) から、もしくは Homebrew などを使いインストールしてください。
`go version` コマンドを実行し、バージョン情報が表示されることを確認してください。

```
$ go version    # go version go1.20.3 darwin/amd64
```

### Editor

[Visual Studio Code](https://code.visualstudio.com/) や [Goland](https://www.jetbrains.com/go/promo/) などを用意してください。
私のおすすめは Goland です。（有料ですが。。。）

### Docker

ローカル環境でMySQLを動かすために使います。
今回は使用しませんが、将来的に使います。


## HelloWorld

任意の作業ディレクトリに移動し、`main.go` というファイルを作成します。

```
touch main.go
```

作成したファイルをエディタで開き、以下のコードを入力します。

{{< gist takoikatakotako de1d47444847957187ced0ca3413a315 >}}

入力が完了したら以下のコマンドを実行し、`Hello World` と出力されることを確認します。

```
go run main.go    # Hello World
```


## サーバーを起動させてHello World

正常に Hello World と表示されましたか?
次に以下のコードを入力し、`main.go` を実行します。

{{< gist takoikatakotako 22a41840691464c74c0278b1a50968c6 >}}

ブラウザを表示し、[http://localhost:8080/](http://localhost:8080/) にアクセスすると `Hello World` と表示されれば成功です。

最後に `control` + `c` でGoの実行を停止させます。


## 参考

[Go言語でhttpサーバーを立ち上げてHello Worldをする](https://qiita.com/taizo/items/bf1ec35a65ad5f608d45)
