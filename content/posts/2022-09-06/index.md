+++
title = "ldd（LPIC）"
url = "2022-09-06"
date = "2022-09-06"
description = "ldd（LPIC）"
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

# ldd

lddコマンドは共有ライブラリへの依存関係を表示するコマンドです。


## サンプル

### /usr/bin/slが必要とする共有ライブラリの一覧を表示する

```
$ ldd /usr/bin/sl
```

```
	linux-vdso.so.1 (0x00007ffca1f76000)
	libncurses.so.6 => /lib64/libncurses.so.6 (0x00007f233b61d000)
	libtinfo.so.6 => /lib64/libtinfo.so.6 (0x00007f233b5ee000)
	libc.so.6 => /lib64/libc.so.6 (0x00007f233b3e5000)
	/lib64/ld-linux-x86-64.so.2 (0x00007f233b651000)
```
