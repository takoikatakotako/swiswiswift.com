+++
title = "リダイレクト（LPIC）"
url = "2022-07-24"
date = "2022-07-24"
description = "リダイレクト（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

# リダイレクト

リダイレクトをすることで出力結果やエラーをテキストファイルに出力したりすることができます。


## 標準出力結果を file.txt に出力する

```
$ echo "shorlax" > file.txt
```

上記の例は以下の例と同等です。

```
$ echo "shorlax" 1 > file.txt
```

すでに `file.txt` が存在する状態で上記らのコマンドを実行すると上書きされます。


## 標準出力結果を file.txt に追記する

```
$ echo "shorlax" >> file.txt
```

ファイルが存在しない場合は作成されます。

```
$ echo "ditto" >> file.txt
```

```
$ cat file.txt
```

```
shorlax
ditto
```


## 標準エラー出力されたといのみファイルに出力する

```
$ snorlax 2> error.txt
```

`snorlx` は存在しないコマンドです。

```
$ cat error.txt
```

```
zsh: command not found: snorlax
```


## 標準出力、標準エラー出力の両方をファイルに出力（追記）する

```
$ echo "snorlax" &>> log.txt
```

```
$ snorlax &>> log.txt
```

```
$ cat log.txt
```

```
snorlax
zsh: command not found: snorlax
```

これらの同様に標準出力、標準エラー出力の両方をファイルに出力（追記）します。

```
$ echo "snorlax" >>& log.txt
$ snorlax >>& log.txt
```

```
$ echo "snorlax" 1>> log.txt 2>&1
$ snorlax 1>> log.txt 2>&1
```


## pokemons.txt の内容を標準入力から取り込み検索する

```
$ grep "snorlax" < pokemons.txt 
```

```
snorlax
```

```
$ cat pokemons.txt
```

```
snorlax
ditto
slowpoke
```


## | を使い次のコマンドに標準入力を渡す

```
$ cat pokemons.txt | head -2
```

```
snorlax
ditto
```


## 標準出力、標準エラー出力のどちらもファイル、デバイスに表示されないようにする

```
$ echo "snorlax" > /dev/null 2>&1
$ snorlax > /dev/null 2>&1
```
