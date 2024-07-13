+++
title = "mvコマンド（LPIC）"
url = "2022-07-05"
date = "2022-07-05"
description = "mvコマンド（LPIC）"
tags = [
  "Linux",
  "LPIC"
]
categories = [
  "Linux",
  "LPIC"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

# mv

ファイルやディレクトリの移動に使用するコマンドです。

### `memo.txt` を `memo2.txt` にリネームする

```
$ mv memo.txt memo2.txt
```

### `/tmp/snorlax` ディレクトリにあるすべてのファイル、サブディレクトリをカレントディレクトリに移動させる

```
$ mv -f /tmp/snorlax/ .
```
