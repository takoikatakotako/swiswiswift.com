+++
title = "mkfs（LPIC）"
url = "2022-09-20"
date = "2022-09-20"
description = "mkfs（LPIC）"
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

# mkfs,mke2fs

ファイルシステムの作成（初期化）を行うコマンドです。


## オプション

### -t

ファイルシステムのタイプを指定します。
このオプションを使って指定しなかった場合は ext2 ファイルシステムを作成します。


## サンプル

### 


```
$ mkfs -t ext3 /dev/vda2
```