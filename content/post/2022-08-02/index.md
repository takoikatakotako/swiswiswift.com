+++
title = "wc（LPIC）"
url = "2022-08-02"
date = "2022-08-02"
description = "wc（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

# wc

テキストファイルの文字数や行数を数えるコマンドです。


## オプション

### -c

バイト数だけを出力する。

### -l

行数だけを出力する。

### -w

単語数だけを出力する


## サンプル

### pokeons.txt の行数を出力する

```
$ wc -l pokemons.txt
```