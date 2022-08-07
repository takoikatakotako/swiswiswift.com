+++
title = "umount"
url = "2022-10-17"
date = "2022-10-17"
description = "umount"
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

# umount

ファイルシステムをルートファイルシステムから切り離す（アンマウントする）ためのコマンドです。


## オプション

### -a

/etc/fstab ファイルに記載されているファイルシステムをすべてアンマウントする

### -r

アンマウントが失敗した場合、読み取り専用での再マウントを試みる

### -t

指定したファイプのファイルシステムのみに対してアンマウントする
