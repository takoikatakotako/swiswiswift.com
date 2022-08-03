+++
title = "fdisk（LPIC）"
url = "2022-08-22"
date = "2022-08-22"
description = "fdisk（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

# fdisk

パーティションを作成、削除するコマンドです。


## オプション

### -d

領域を削除

### -l

パーテションのタイプを表示

### -m

利用可能なメニューの表示


## サンプル

### 作成済みのパーティションテーブルを表示する

```
$ fdisk -l
```

```
Disk /dev/loop0: 79.95 MiB, 83832832 bytes, 163736 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop1: 44.68 MiB, 46845952 bytes, 91496 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop2: 61.89 MiB, 64901120 bytes, 126760 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop3: 46.96 MiB, 49242112 bytes, 96176 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop4: 61.96 MiB, 64970752 bytes, 126896 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/vda: 30 GiB, 32212254720 bytes, 62914560 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disklabel type: gpt
Disk identifier: 64B20E78-04A0-4D37-AD8D-B205396AABE0

Device     Start      End  Sectors Size Type
/dev/vda1   2048     4095     2048   1M BIOS boot
/dev/vda2   4096 62914526 62910431  30G Linux filesystem
```

