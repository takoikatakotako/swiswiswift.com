+++
title = "gzip, gunzip（LPIC）"
url = "2022-07-18"
date = "2022-07-18"
description = "gzip, gunzip（LPIC）"
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

# gzip, gunzip

`gzip` は圧縮に、`gunzip` は解凍に使われるコマンドです。

## サンプル

### file1.txt をgzipで圧縮する

```
$ gzip file1.txt
```

`file1.txt.gz` が生成され、`file1.txt` が消えます。

### file1.txt.gz をgunzipで解凍する

```
$ gunzip file1.txt.gz
```

`file1.txt` が生成され、`file1.txt.gz` が消えます。
`file1.txt.gz` を `snorlax.txt.gz` とリネームした後に、`gunzip snorlax.txt.gz` と実行すると `snorlax.txt` が生成されます。

### 解凍せずに格納されているファイル名を確認する

ファイルを作成します。

```
$ touch file1.txt file2.txt
```

`archive.tar` を作成します。

```
$ tar cf archive.tar file1.txt file2.txt
```

`archive.tar` を圧縮します。
`archive.tar` が削除され `archive.tar.gz` が作成されます。

```
$ gzip archive.tar
```

`archive.tar.gz` を解凍せずに格納されているファイル名を確認します。

```
$ gzip -dc archive.tar.gz | tar -tvf -
```

```
-rw-r--r--  0 snorlax staff       0  8  9 17:04 file1.txt
-rw-r--r--  0 snorlax staff       0  8  9 17:04 file2.txt
```
