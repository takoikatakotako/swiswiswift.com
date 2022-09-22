+++
title = "fsck,e2fsck（LPIC）"
url = "2022-10-29"
date = "2022-10-29"
description = "fsck,e2fsck（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

# fsck,e2fsck

ファイルシステムにエラーがないかどうかのチェックと修復を行うコマンドです。


## オプション

### -A

/etc/fstabにあるファイルシステムを全て検査する


## サンプル

### /dev/vda2 をチェックする

```
$ fsck /dev/vda2
```

### /etc/fstab にあるファイルシステムを全て検査する

```
$ fsck -A
```
