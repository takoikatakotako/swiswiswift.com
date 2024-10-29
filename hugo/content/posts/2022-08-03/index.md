+++
title = "od（LPIC）"
url = "2022-08-03"
date = "2022-08-03"
description = "od（LPIC）"
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

# od

ファイルの内容を8進数で表示するコマンドです。


## オプション

### -d

Decimal（10進数）で表示する

### -x

Hexa Decimal（16進数）で表示する


## サンプル

### pokeons.txt の内容を16進数で出力する

```
$ od -x pokemons.txt
```
