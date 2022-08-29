+++
title = "netstat（LPIC）"
url = "2022-12-16"
date = "2022-12-16"
description = "netstat（（LPIC）"
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

# netstat

TCPとUDPのサービスポートの状態、UNIXドメインソケットの状態、ルーティングルーティング情報などを表示します。

## オプション

### -a

すべてのプロトコル（TCP、UDP、UNIXソケット）を表示

### -l

接続待ちのソケットを表示

### -n

ホスト、ポート、ユーザーなど名前を解決せず、数字のアドレスを表示

### -p

ソケット/ポートをオープンしているプログラムのPIDと名前を表示

### -r

ルーティングテーブルを表示

### -s

統計情報を表示

### -t

TCPソケットを表示

### -u

UDPソケットを表示

### -x

UNIXソケットを表示


## サンプル

### すべてのプロトコル（TCP、UDP、UNIXソケット）を表示

```
$ netstat -a
```

```
Active Internet connections (servers and established)
Proto Recv-Q Send-Q Local Address           Foreign Address         State      
tcp        0      0 localhost:domain        0.0.0.0:*               LISTEN     
tcp        0      0 0.0.0.0:ssh             0.0.0.0:*               LISTEN     
tcp        0    348 v160-251-101-197.3f:ssh fpb6aa6cb4.ap.nur:59895 ESTABLISHED
...
```

### ルーティングテーブルを表示

```
$ netstat -r
```

```
Kernel IP routing table
Destination     Gateway         Genmask         Flags   MSS Window  irtt Iface
default         v160-251-100-1. 0.0.0.0         UG        0 0          0 eth0
cache12.cloud.z v160-251-100-1. 255.255.255.255 UGH       0 0          0 eth0
160.251.100.0   0.0.0.0         255.255.254.0   U         0 0          0 eth0
v160-251-100-1. 0.0.0.0         255.255.255.255 UH        0 0          0 eth0
cache13.cloud.z v160-251-100-1. 255.255.255.255 UGH       0 0          0 eth0
```
