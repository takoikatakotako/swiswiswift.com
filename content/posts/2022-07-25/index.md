+++
title = "tee（LPIC）"
url = "2022-07-25"
date = "2022-07-25"
description = "tee（LPIC）"
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

# tee

標準入力から読み込んだデータ尾を標準出力とファイルの両方に出力するコマンドです。


## サンプル

### pokemons.txt を行番号付きで読み込み、pokemons-with-line.txt に保存し、最初の2行を表示する。

```
$ cat -n pokemons.txt | tee pokemons-with-line.txt | head -2
```

```
     1	snorlax
     2	ditto
```
