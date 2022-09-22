+++
title = "rmコマンド（LPIC）"
url = "2022-07-07"
date = "2022-07-07"
description = "rmコマンド（LPIC）"
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

# rm

ファイルを削除するコマンドです。

## オプション

### -i

ファイルを削除する前にユーザーへ確認する

### -f

ユーザーへの確認無しに削除する

### -R（もしくは-r）

指定されたディレクトリ内にファイル、ディレクトリが存在していても全て削除する


## サンプル

### `memo3.txt`　を削除する

```
$ rm memo3.txt
```

### `/tmp` ディレクトリの下にあるサブディレクトリを全て削除する

```
$ rm -rf /tmp/*
```
