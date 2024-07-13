+++
title = "tail（LPIC）"
url = "2022-07-29"
date = "2022-07-29"
description = "tail（LPIC）"
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

# tail

テキストファイルの末尾部分を表示するコマンドです。
デフォルトでは10行目まで表示します。


## オプション

### -n

行数を数字で指定する。

### -f

ファイルの最終部分を読み続けます。増えていくログファイルの確認に便利です。


## サンプル

### pokemons.txtの末尾を表示

```
$ tail pokemons.txt
```

### pokemons.txtの末尾3行を表示

```
$ tail -3 pokemons.txt
```


### pokemons.txtの末尾を表示し続ける

```
$ tail -f pokemons.txt
```

このコマンドを実行後、pokemons.txtを変更すると末尾が更新されます。
