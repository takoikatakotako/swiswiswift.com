+++
title = "grep（LPIC）"
url = "2022-07-27"
date = "2022-07-27"
description = "grep（LPIC）"
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

# grep

テキストデータ内の文字列検索を行うコマンドです。


## オプション

### -v

パターンに一致しない行を表示する

### -n

行番号を表示する

### -l

パターンと一致するファイル名を表示

### -i

大文字と小文字を区別しないで検索を行う

### -e

パターンを使って検索を行う


## サンプル

### pokemons.txtからSnorlaxを検索する

```
$ grep Snorlax pokemons.txt
```

```
Snorlax
```

### pokemons.txtから大文字小文字の区別なくsnorlaxを検索する

```
$ grep -i SNORLAX pokemons.txt
```

```
Snorlax
```


### pokemons.txtからSnorlax以外を検索する

```
$ grep -v Snorlax pokemons.txt
```

```
Ditto
Slowpoke
```


### pokemons.txtから末尾がlaxの行を検索する

```
$ grep -e lax$ pokemons.txt
```

```
Snorlax
```
