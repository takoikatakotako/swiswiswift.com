+++
title = "Conohaでディスクを追加する"
url = "2022-10-14"
date = "2022-10-14"
description = "Conohaでディスクを追加する"
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

Conohaでディスクを追加する方法です。
まずはサーバーを立ち上げ、ファイルシステムの使用状況を確認します。

```
$ df -T -h
```

```
Filesystem     Type   Size  Used Avail Use% Mounted on
tmpfs          tmpfs   47M 1000K   46M   3% /run
/dev/vda2      ext4    30G  6.0G   23G  22% /
tmpfs          tmpfs  235M     0  235M   0% /dev/shm
tmpfs          tmpfs  5.0M     0  5.0M   0% /run/lock
tmpfs          tmpfs  235M     0  235M   0% /run/qemu
tmpfs          tmpfs   47M  4.0K   47M   1% /run/user/0
```

`/dev` ディレクトリを確認します。

```
$ ls /dev
```

```
...
vda
vda1
vda2
...
```

[こちら](https://support.conoha.jp/v/diskoperation/) を参考にしながらディスクを追加します。
ディスク追加時はサーバーを一度シャットダウンする必要があります。

参考: [追加ディスクを管理する](https://support.conoha.jp/v/diskoperation/)


ディスク追加後にサーバーを起動し、`/dev` ディレクトリを確認します。
`vdb` ディスクが追加されていることを確認します。

```
$ ls /dev
```

```
...
vda
vda1
vda2
vdb
...
```

`vdb` ディスクをフォーマットします。
`vda`が `ext4` なので `vdb` も同じように `ext4` でフォーマットします。

```
$ mkfs -t ext4 /dev/vdb
```

マウント先のディレクトリを作成します。

```
$ mkdir /data
```

`/data` に `/dev/vdb` をマウントします。

```
$ mount /dev/vdb /data
```

ファイルシステムの使用状況を確認します。
`/dev/vdb` が追加されていることを確認します。

```
$ df -T -h
```

```
Filesystem     Type   Size  Used Avail Use% Mounted on
tmpfs          tmpfs   47M 1000K   46M   3% /run
/dev/vda2      ext4    30G  6.0G   23G  22% /
tmpfs          tmpfs  235M     0  235M   0% /dev/shm
tmpfs          tmpfs  5.0M     0  5.0M   0% /run/lock
tmpfs          tmpfs  235M     0  235M   0% /run/qemu
tmpfs          tmpfs   47M  4.0K   47M   1% /run/user/0
/dev/vdb       ext4   196G   28K  186G   1% /data
```

次にパーティションを作ってみます。
`/dev/vdb` をアンマウントします。

```
$ umount /dev/vdb
```

ファイルシステムの使用状況を確認します。
`/dev/vdb` が無くなっていることを確認します。

```
$ df -T -h
```

```
Filesystem     Type   Size  Used Avail Use% Mounted on
tmpfs          tmpfs   47M 1000K   46M   3% /run
/dev/vda2      ext4    30G  6.0G   23G  22% /
tmpfs          tmpfs  235M     0  235M   0% /dev/shm
tmpfs          tmpfs  5.0M     0  5.0M   0% /run/lock
tmpfs          tmpfs  235M     0  235M   0% /run/qemu
tmpfs          tmpfs   47M  4.0K   47M   1% /run/user/0
```

パーティションを作成します。
`Command (m for help):` の後にコマンドを入力していきます。

```
$ fdisk /dev/vdb
```

```
Welcome to fdisk (util-linux 2.37.2).
Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.

This disk is currently in use - repartitioning is probably a bad idea.
It's recommended to umount all file systems, and swapoff all swap
partitions on this disk.

The device contains 'ext4' signature and it will be removed by a write command. See fdisk(8) man page and --wipe option for more details.

Device does not contain a recognized partition table.
Created a new DOS disklabel with disk identifier 0x24cf7bf5.

Command (m for help): p
Disk /dev/vdb: 200 GiB, 214748364800 bytes, 419430400 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disklabel type: dos
Disk identifier: 0x24cf7bf5

Command (m for help): n
Partition type
   p   primary (0 primary, 0 extended, 4 free)
   e   extended (container for logical partitions)
Select (default p): p
Partition number (1-4, default 1): 1
First sector (2048-419430399, default 2048): 
Last sector, +/-sectors or +/-size{K,M,G,T,P} (2048-419430399, default 419430399): +20G

Created a new partition 1 of type 'Linux' and of size 20 GiB.

Command (m for help): n
Partition type
   p   primary (1 primary, 0 extended, 3 free)
   e   extended (container for logical partitions)
Select (default p): p
Partition number (2-4, default 2): 
First sector (41945088-419430399, default 41945088): 
Last sector, +/-sectors or +/-size{K,M,G,T,P} (41945088-419430399, default 419430399): +30G

Created a new partition 2 of type 'Linux' and of size 30 GiB.

Command (m for help): n
Partition type
   p   primary (2 primary, 0 extended, 2 free)
   e   extended (container for logical partitions)
Select (default p): p
Partition number (3,4, default 3): 
First sector (104859648-419430399, default 104859648): 
Last sector, +/-sectors or +/-size{K,M,G,T,P} (104859648-419430399, default 419430399): +30G

Created a new partition 3 of type 'Linux' and of size 30 GiB.

Command (m for help): n
Partition type
   p   primary (3 primary, 0 extended, 1 free)
   e   extended (container for logical partitions)
Select (default e): p

Selected partition 4
First sector (167774208-419430399, default 167774208): 
Last sector, +/-sectors or +/-size{K,M,G,T,P} (167774208-419430399, default 419430399): +40G

Created a new partition 4 of type 'Linux' and of size 40 GiB.

Command (m for help): w
The partition table has been altered.
Syncing disks.
```

`vdb1` - `vdb4` パーテション作られていることを確認します。

```
$ fdisk -l /dev/vdb
```

```
Disk /dev/vdb: 200 GiB, 214748364800 bytes, 419430400 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disklabel type: dos
Disk identifier: 0x24cf7bf5

Device     Boot     Start       End  Sectors Size Id Type
/dev/vdb1            2048  41945087 41943040  20G 83 Linux
/dev/vdb2        41945088 104859647 62914560  30G 83 Linux
/dev/vdb3       104859648 167774207 62914560  30G 83 Linux
/dev/vdb4       167774208 251660287 83886080  40G 83 Linux
```

```
$ ls /dev
```

```
...
vda
vda1
vda2
vdb
vdb1
vdb2
vdb3
vdb4
...
```

マウントします。

```
$ mkfs -t ext4 /dev/vdb1
$ mkdir /vdb1
$ mount /dev/vdb1 /vdb1
```

```
$ mkfs -t ext4 /dev/vdb2
$ mkdir /vdb2
$ mount /dev/vdb2 /vdb2
```

```
$ mkfs -t ext4 /dev/vdb3
$ mkdir /vdb3
$ mount /dev/vdb3 /vdb3
```

```
$ mkfs -t ext4 /dev/vdb4
$ mkdir /vdb4
$ mount /dev/vdb4 /vdb4
```

参考: [追加SSDの設定方法](https://support.conoha.jp/v/addssd/?btn_id=v-changedisk-related_v-addssd)
