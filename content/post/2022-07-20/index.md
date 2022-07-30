+++
title = "xz,unxz（LPIC）"
url = "2022-07-20"
date = "2022-07-20"
description = "xz,unxz（LPIC）"
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

# xz,unxz

`xz` は圧縮に、`unxz` は解凍に使われるコマンドです。

## サンプル

### file1.txt をxzで圧縮する

```
$ xz file1.txt
```

`file1.txt.xz` が生成され、`file1.txt` が消えます。

### file1.txt.xz をunxzで解凍する

```
$ unxz file1.txt.xz
```

`file1.txt` が生成され、`file1.txt.xz` が消えます。
`file1.txt.xz` を `snorlax.txt.xz` とリネームした後に、`unxz snorlax.txt.xz` と実行すると `snorlax.txt` が生成されます。
