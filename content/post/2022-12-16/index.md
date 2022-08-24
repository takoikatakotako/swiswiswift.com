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


```
$ netstat -nr
```

```
Kernel IP routing table
Destination     Gateway         Genmask         Flags   MSS Window  irtt Iface
0.0.0.0         160.251.100.1   0.0.0.0         UG        0 0          0 eth0
157.7.180.133   160.251.100.1   255.255.255.255 UGH       0 0          0 eth0
160.251.100.0   0.0.0.0         255.255.254.0   U         0 0          0 eth0
160.251.100.1   0.0.0.0         255.255.255.255 UH        0 0          0 eth0
163.44.76.148   160.251.100.1   255.255.255.255 UGH       0 0          0 eth0
```
