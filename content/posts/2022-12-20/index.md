+++
title = "ifconfig,ifup,ifdown,etc（LPIC）"
url = "2022-12-20"
date = "2022-12-20"
description = "ifconfig,ifup,ifdown,etc（LPIC）"
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

# ifconfig

ネットワークI/Fの設定、表示するコマンドです。

```
$ ifconfig
```




### ネットワークインターフェース eth0 の送受信バイト数を表示

```
$ ifconfig eth0
```


### ネットワークインターフェースeth0に、IPアドレス　192.168.0.50、サブネットマスク 255.255.255.0 を設定する

```
$ ifconfig eth0 192.168.0.50 netmask 255.255.255.0
```

# ifup

指定したネットワークインターフェースを有効にするコマンドです。

```
$ ifup [ネットワークインターフェース]
```

# ifdown

指定したネットワークインターフェースを無効にするコマンドです。

```
$ ifdown [ネットワークインターフェース]
```
