+++
title = "dpkg（LPIC）"
url = "2022-09-28"
date = "2022-09-28"
description = "dpkg（LPIC）"
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

# dpkg


## オプション

### -l, --list

インストール済みの全debパッケージの情報を表示します。

### -s, --status

指定したパッケージの情報を表示。

### -L, --listfiles

指定したパッケージに含まれるすべてのファイルを表示

### -S, --search

インストール済みのパッケージから指定されたファイルを検索

### -I, --info

指定したパッケージの詳細情報を表示

### -C, --audit

インストールが完了していないパッケージを検索

### -c, --contents

インストールされたパッケージではなく、指定したdebパッケージファイルに含まれるファイルの一覧を表示

### -r, --remove

パッケージは削除するが、設定ファイルは残したままとする。

### -P, --purge

設定ファイルも含め完全にパッケージを削除する



## サンプル

### slに含まれるファイルをすべて表示する

```
$ apt install sl
$ dpkg -L sl
```

`-L` は `--listfiles` の省略形です。

```
$ dpkg --listfiles sl
```


### インストール済みのパッケージから /etc/mke2fs.conf ファイルが含まれているパッケージを表示する

```
$ dpkg -S /etc/mke2fs.conf
```

```
e2fsprogs: /etc/mke2fs.conf
```


### エラーなどで部分的にインストールされたパッケージを検索する

```
$ dplg -C
```

