+++
title = "cpコマンド（LPIC）"
url = "2022-07-04"
date = "2022-07-04"
description = "cpコマンド（LPIC）"
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

# cp

ファイルやディレクトリを複製する場合に使うコマンドです。

## オプション

### -i

コピー先に同名ファイルが存在する場合、上書きするか確認する

### -f

コピー先に同名ファイルが存在する場合、上書きするか確認する

### -p

コピーした元の所有者、タイムスタンプ、アクセス権などの情報を保持したままコピーする

### -R（もしくは-r）

コピー元のディレクトリ改装をそのままコピーする


## サンプル

### `memo.txt` を `memo2.txt` という名前でコピーする

```
$ cp memo.txt memo2.txt
```

### `ffmepg` というディレクトリ内のすべてのファイル、サブディレクトリを `ffmpeg2` という名前でコピーする

```
$ cp -r ffmepg ffmpeg2
```

