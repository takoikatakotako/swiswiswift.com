+++
title = "lsblk"
url = "2022-10-16"
date = "2022-10-16"
description = "lsblk"
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

# lsblk

利用可能なブロックデバイスの一覧を表示するコマンドです。


## サンプル

### 利用可能なブロックデバイスの一覧を表示する

```
$ lsblk
```

```
NAME   MAJ:MIN RM  SIZE RO TYPE MOUNTPOINTS
loop0    7:0    0 44.7M  1 loop /snap/snapd/15534
loop1    7:1    0 79.9M  1 loop /snap/lxd/22923
loop2    7:2    0   62M  1 loop /snap/core20/1587
loop3    7:3    0   47M  1 loop /snap/snapd/16292
loop4    7:4    0 61.9M  1 loop /snap/core20/1405
sr0     11:0    1  494K  0 rom  
vda    252:0    0   30G  0 disk 
├─vda1 252:1    0    1M  0 part 
└─vda2 252:2    0   30G  0 part /myapp
                                /
```
