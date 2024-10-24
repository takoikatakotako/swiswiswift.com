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

文字群1で合致した文字を削除する

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



### file.txtの英小文字をすべて大文字にする

```
$ cat file.txt
```

```
Ditto
Slowpoke
Snorlax
```

```
$ tr 'a-z' 'A-Z' < file.txt 
```

```
DITTO
SLOWPOKE
SNORLAX
```

以下のコマンドでも英小文字をすべて大文字にする

```
$ cat file.txt | tr 'a-z' 'A-Z'
$ tr [:lower:] [:upper:] < file.txt
$ tr '[:lower:]' '[:upper:]' < file.txt
```


### file.txtからlaxを削除して表示する

```
$ tr -d 'lax' < file.txt
```

```
Ditto
Sowpoke
Snor
```
