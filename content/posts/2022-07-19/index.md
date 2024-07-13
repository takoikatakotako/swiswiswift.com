+++
title = "bzip2,bunzip2（LPIC）"
url = "2022-07-19"
date = "2022-07-19"
description = "bzip2,bunzip2（LPIC）"
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

# bzip2,bunzip2

`bzip2` は圧縮に、`bunzip2` は解凍に使われるコマンドです。

## サンプル

### file1.txt をbzip2で圧縮する

```
$ bzip2 file1.txt
```

`file1.txt.bz2` が生成され、`file1.txt` が消えます。

### file1.txt.bz2 をbunzip2で解凍する

```
$ bunzip2 file1.txt.bz2
```

`file1.txt` が生成され、`file1.txt.bz2` が消えます。
`file1.txt.bz2` を `snorlax.txt.bz2` とリネームした後に、`bunzip2 snorlax.txt.bz2` と実行すると `snorlax.txt` が生成されます。
