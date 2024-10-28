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


### ファイルパテーションタイプの一覧を確認する

```
Command (m for help): l

00 Empty            24 NEC DOS          81 Minix / old Lin  bf Solaris        
01 FAT12            27 Hidden NTFS Win  82 Linux swap / So  c1 DRDOS/sec (FAT-
02 XENIX root       39 Plan 9           83 Linux            c4 DRDOS/sec (FAT-
03 XENIX usr        3c PartitionMagic   84 OS/2 hidden or   c6 DRDOS/sec (FAT-
04 FAT16 <32M       40 Venix 80286      85 Linux extended   c7 Syrinx         
05 Extended         41 PPC PReP Boot    86 NTFS volume set  da Non-FS data    
06 FAT16            42 SFS              87 NTFS volume set  db CP/M / CTOS / .
07 HPFS/NTFS/exFAT  4d QNX4.x           88 Linux plaintext  de Dell Utility   
08 AIX              4e QNX4.x 2nd part  8e Linux LVM        df BootIt         
09 AIX bootable     4f QNX4.x 3rd part  93 Amoeba           e1 DOS access     
0a OS/2 Boot Manag  50 OnTrack DM       94 Amoeba BBT       e3 DOS R/O        
0b W95 FAT32        51 OnTrack DM6 Aux  9f BSD/OS           e4 SpeedStor      
0c W95 FAT32 (LBA)  52 CP/M             a0 IBM Thinkpad hi  ea Linux extended 
0e W95 FAT16 (LBA)  53 OnTrack DM6 Aux  a5 FreeBSD          eb BeOS fs        
0f W95 Ext'd (LBA)  54 OnTrackDM6       a6 OpenBSD          ee GPT            
10 OPUS             55 EZ-Drive         a7 NeXTSTEP         ef EFI (FAT-12/16/
11 Hidden FAT12     56 Golden Bow       a8 Darwin UFS       f0 Linux/PA-RISC b
12 Compaq diagnost  5c Priam Edisk      a9 NetBSD           f1 SpeedStor      
14 Hidden FAT16 <3  61 SpeedStor        ab Darwin boot      f4 SpeedStor      
16 Hidden FAT16     63 GNU HURD or Sys  af HFS / HFS+       f2 DOS secondary  
17 Hidden HPFS/NTF  64 Novell Netware   b7 BSDI fs          fb VMware VMFS    
18 AST SmartSleep   65 Novell Netware   b8 BSDI swap        fc VMware VMKCORE 
1b Hidden W95 FAT3  70 DiskSecure Mult  bb Boot Wizard hid  fd Linux raid auto
1c Hidden W95 FAT3  75 PC/IX            bc Acronis FAT32 L  fe LANstep        
1e Hidden W95 FAT1  80 Old Minix        be Solaris boot     ff BBT            

Aliases:
   linux          - 83
   swap           - 82
   extended       - 05
   uefi           - EF
   raid           - FD
   lvm            - 8E
   linuxex        - 85
```
