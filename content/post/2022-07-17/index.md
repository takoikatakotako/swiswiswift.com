+++
title = "tar（LPIC）"
url = "2022-07-17"
date = "2022-07-17"
description = "tar（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

# tar

アーカイブファイルの管理に使用するコマンドです。


## オプション

### -c

アーカイブファイルを作成する

### -t

アーカイブファイルの内容を表示する

### -X

アーカイブファイルを展開する

### -f

アーカイブファイル名を指定する

### -v

詳細情報を表示する

### -j

アーカイブに対して、bzip2を使用する

### -J

アーカイブに対して、xzを使用する

### -Z

アーカイブに対して、gzipを使用する


## サンプル

### file1.txt file2.txt　を含む archive.tar を作成する

```
$ tar cf archive.tar file1.txt file2.txt
```

### file1.txt file2.txt　を含む archive.tar.gz を作成する

```
$ tar cfz archive.tar.gz file1.txt file2.txt
```

gzipで圧縮されているのでgunzipで解凍できます。

```
$ gunzip archive.tar.gz
```



```
$ tar zxf archive.tar.gz
```

### file1.txt file2.txt　を含む archive.tar.bz2 を作成する

```
$ tar cfj archive.tar.bz2 file1.txt file2.txt
```

bzipで圧縮されているのでbunzip2で解凍できます。

```
$ bunzip2 archive.tar.bz2
```




### archive.tar 内のすべてのファイルの詳細を一覧表示する

```
$ tar tvf archive.tar
```

```
-rw-r--r--  0 snorlax staff      20  7  4 10:42 file1.txt
-rw-r--r--  0 snorlax staff      23  7  4 10:42 file2.txt
```

### archive.tar からすべてのファイルを展開する

```
$ tar xf archive.tar
```

MacのGUIでやる場合と異なり、フォルダなどは作られずに展開される。

