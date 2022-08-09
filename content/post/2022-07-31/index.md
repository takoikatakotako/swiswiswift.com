+++
title = "tr（LPIC）"
url = "2022-07-31"
date = "2022-07-31"
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

# sed

テキストの置換に誓われるコマンドです。


## オプション

### -i

編集結果をファイルに書き込む。


## サンプル

### pokemons.txtの中の最初のsnorlaxをkabigonに置換して表示する

```
$ sed 's/snorlax/kabigon/' pokemons.txt
```

### pokemons.txtの中のすべてのsnorlaxをkabigonに置換して表示する

```
$ sed 's/snorlax/kabigon/g' pokemons.txt
```
　