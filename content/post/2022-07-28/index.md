+++
title = "head（LPIC）"
url = "2022-07-28"
date = "2022-07-28"
description = "head（LPIC）"
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

# head

テキストファイルの先頭部分を表示するコマンドです。
デフォルトでは10行目まで表示します。


## オプション

### -n

行数を数字で指定する。


## サンプル

### pokemons.txtの先頭を表示

```
$ head pokemons.txt
```

### pokemons.txtの先頭3行を表示

```
$ head -3 pokemons.txt
```

