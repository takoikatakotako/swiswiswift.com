+++
title = "cat（LPIC）"
url = "2022-07-23"
date = "2022-07-23"
description = "cat（LPIC）"
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

# cat

`cat` はテキストを表示するために使うコマンドです。


## オプション

### -n

行番号を表示します。


## サンプル

### file.txt　を表示する

```
$ cat file.txt
```

### file.txt　を行番号付きで表示する

```
$ cat -n file.txt
```

### 複数行の文字列を表示する

```
$ cat << END
I
Love 
Snorlax
END
```

### 複数行の文字列をファイルに保存する

```
$ cat << END > snorlax.txt
I
Love 
Snorlax
END
```
