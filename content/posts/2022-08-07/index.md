+++
title = "fgrep（LPIC）"
url = "2022-08-07"
date = "2022-08-07"
description = "fgrep（LPIC）"
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

# fgrep

fgrepは正規表現を使用せずに検索したい時に使用します。

grep コマンドではこのように正規表現を使ってファイルを検索することができます。
以下の例では先頭が sno であるポケモンを検索しています。

```
$ grep ^sno pokemons.txt
```

fgrep コマンドは正規表現を使用せずにそのままの単語を検索します。
そのため以下の例では何も出力されません。

```
$ fgrep ^sno pokemons.txt
```