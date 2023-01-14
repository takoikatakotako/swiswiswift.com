+++
title = "route（LPIC）"
url = "2022-12-22"
date = "2022-12-22"
description = "route（LPIC）"
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

# route

ルーティングテーブルの設定と表示を行うコマンドです。


### 表示

```
$ route
```

```
Kernel IP routing table
Destination     Gateway         Genmask         Flags Metric Ref    Use Iface
default         v160-251-100-1. 0.0.0.0         UG    100    0        0 eth0
cache12.cloud.z v160-251-100-1. 255.255.255.255 UGH   100    0        0 eth0
160.251.100.0   0.0.0.0         255.255.254.0   U     100    0        0 eth0
v160-251-100-1. 0.0.0.0         255.255.255.255 UH    100    0        0 eth0
cache13.cloud.z v160-251-100-1. 255.255.255.255 UGH   100    0        0 eth0
```

### 追加

```
$ route add { -net | -host } 宛先 [ネットマスク] ゲートウェイ [インターフェース名]
```

### 削除

```
$ route del { -net | -host } 宛先 [ネットマスク] ゲートウェイ [インターフェース名]
```


## サンプル

以下の様なルートテーブルの場合、192.1682.254を宛先とするパケットはDestination 192.168.2.0、Genmask 255.255.255.0 のエントリに一致するため、Gateway 192.168.2.1 に送られます。

```
Destination     Gateway         Genmask         Flags Metric Ref    Use Iface
0.0.0.0         172.16.1.1      0.0.0.0         UG    100    0        0 eth0
192.168.1.0     192.168.1.1     255.255.255.0   UGH   100    0        0 eth0
192.168.2.0     192.168.2.1     255.255.255.0   U     100    0        0 eth0
```