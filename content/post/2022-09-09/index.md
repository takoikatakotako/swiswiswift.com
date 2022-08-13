+++
title = "rpm2cpio（LPIC）"
url = "2022-09-09"
date = "2022-09-09"
description = "rpm2cpio（LPIC）"
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

# rpm2cpio

rpmコマンドをcpioアーカイブ形式に変換し、標準出力に出力するコマンドです。


## サンプル

### rpmコマンドをcpioアーカイブ形式に変換し、標準出力に出力する

```
$ pm2cpio sl-5.02-1.el7.x86_64.rpm | cpio -t
```

```
./usr/bin/sl
./usr/share/doc/sl-5.02
./usr/share/doc/sl-5.02/LICENSE
./usr/share/doc/sl-5.02/README.ja.md
./usr/share/doc/sl-5.02/README.md
./usr/share/man/ja/man1/sl.1.ja.gz
./usr/share/man/man1/sl.1.gz
37 blocks
```
