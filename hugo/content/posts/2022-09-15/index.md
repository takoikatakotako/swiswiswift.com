+++
title = "シェル変数（LPIC）"
url = "2022-09-15"
date = "2022-09-15"
description = "bash（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

# シェル変数

さまざまなシェル変数についてです。


## 特殊なシェル変数

### $$

シェルのPID

### $?

最後に実行したコマンドの終了値

### $#

因数の個数

### $*

区切り文字で区切られたすべての引数

### $0

実行ファイル名

### $1, $2, ...

1番目の引数、2番目の引数


## サンプル

### シェル変数を設定する

```
$ POKEMON_SHELL=Snorlax
```


