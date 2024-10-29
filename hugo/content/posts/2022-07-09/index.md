+++
title = "touchコマンド（LPIC）"
url = "2022-07-09"
date = "2022-07-09"
description = "touchコマンド（LPIC）"
tags = [
  "Linux",
  "LPIC"
]
categories = [
  "Linux",
  "LPIC"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

# touch

ファイルを作成するコマンドです。

## サンプル

### hello.txtを作る

```
$ touch hello.txt
```

### タイムスタンプを指定してhello.txtを作る

```
$ touch --date="2022/8/8 12:00" 8-8.txt 
```

```
$ ls -l 8-8.txt 
```

```
-rw-r--r-- 1 root root 0 Aug  8 12:00 8-8.txt
```
