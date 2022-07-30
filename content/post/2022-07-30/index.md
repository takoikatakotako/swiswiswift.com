+++
title = "tr（LPIC）"
url = "2022-07-30"
date = "2022-07-30"
description = "tr（LPIC）"
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

# tr

標準入力であるキーボードから入力した文字を指定した文字に変換し、標準出力であるディスプレイに表示します。


## オプション

### -d

文字群1で合致いた文字を削除する

### -s

文字列1で合致した文字の繰り返しを1文字に置き換える


## サンプル

### 入力された文字を大文字にする

```
$ tr 'a-z' 'A-Z'
```

### 入力された文字からsを削除する

```
$ tr -d 's'
```


### pokemons.txtの文字を全て大文字に変換する

```
$ tr 'a-z' 'A-Z' pokemons.txt
```
