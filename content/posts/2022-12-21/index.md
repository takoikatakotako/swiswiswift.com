+++
title = "ip（LPIC）"
url = "2022-12-21"
date = "2022-12-21"
description = "ip（LPIC）"
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

# ip

ネットワークインターフェース、ルーティングテーブルなどを管理するコマンドです。
routeコマンドや、ifconfigコマンドを合わせたようなコマンドです。


### ネットワークインターフェースのデータリンク層の情報を表示する

```
$ ip link show
```

### ルーティングテーブルを表示 

```
$ ip route show
```

### ネットワークインターフェース eth0 の送受信のバイト数を表示する

```
$ ip -s link show dev eth0
```

