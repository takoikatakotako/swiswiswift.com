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


## その他

- カーネル選択メニューが表示されているときに「A」もしくは「E」のキーを押すとカーネルオプションを編集できるようになります。



# GRUB2

ブートローダーです。
GRUBの設定ファイルは `/boot/grub2/grub.cfg` と `/etc/default/grub` です。

## grub-mkconfig

`/etc/default/grub` に設定を記述し、`grub-mkconfig` を実行すると `/boot/grub2/grub.cfg` が生成されます。


# grub-install

GRUBをインストールコマンドです。


## サンプル

### /dev/sdaのMBRにGRUBをインストールする

```
$ grub-install /dev/sda
```

