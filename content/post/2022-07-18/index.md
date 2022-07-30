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
