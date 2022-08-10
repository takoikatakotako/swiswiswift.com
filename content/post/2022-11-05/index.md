+++
title = "GRUB（LPIC）"
url = "2022-11-05"
date = "2022-11-05"
description = "GRUB（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

# GRUB

ブートローダーです。
GRUBの設定ファイルは `/boot/grub/menu.lst` と `/boot/grub/grub.conf` です。


## 設定項目

### default

デフォルトで起動するOSを定義する

### timeout

OSを自動起動するまでの待機時間を指定する

### title

起動するOSに対して名前を定義する。

### root

GRUBのルートデバイスを定義する。

### kernel

カーネルのイメージファイルとカーネルオプションを指定する。

### initrd

初期RAMディスクのイメージファイルを指定する
