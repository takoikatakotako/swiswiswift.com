+++
title = "find（LPIC）"
url = "2022-09-01"
date = "2022-09-01"
description = "find（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

# find

指定したディレクトリ以下で、指定した検索条件に合致するファイルを検索するコマンドです。


## オプション

### -name

指定したファイル名で検索する

### -type

ファイルのタイプで検索する

### -atime

指定した日時をもとに、最終アクセスがあったファイルを検索する

### -mtime

指定した日時をもとに、最終更新されたファイルを検索する

### -maxdepth

検索するサブディレクトリの深さを指定する


## サンプル

### snorlaxをファイル名に含むファイルを検索する

```
$ find . -name snorlax
```

