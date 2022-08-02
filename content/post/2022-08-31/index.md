+++
title = "ln（LPIC）"
url = "2022-08-31"
date = "2022-08-31"
description = "ln（LPIC）"
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

# ln

ファイルへのリンクを作成するコマンドです。


## サンプル

### ハードリンクを作成する

```
$ ln file.txt file.txt-link
```

```
$ echo "snorlax" > file.txt
$ cat file.txt-link
```

```
snorlax
```


### シンボリックリンクを作成する

```
$ ln -s file.txt file.txt-link
```

```
$ echo "snorlax" > file.txt
$ cat file.txt-link
```

```
snorlax
```