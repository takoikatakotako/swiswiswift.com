+++
title = "chown（LPIC）"
url = "2022-08-29"
date = "2022-08-29"
description = "chown（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

# chown

指定されたファイルの所有者とグループを変更します。


## オプション

### -R

ディレクトリのみに指定が可能であり、サブディレクトリを含め再起的に所有者、グループが変更される。


## サンプル

### ファイルの所有者、グループを変更する

snorlaxでファイルを作成します。

```
$ su snorlax
$ touch file.txt
$ ls -l file.txt
```

```
-rw-rw-r-- 1 snorlax snorlax 0 Aug 14 00:51 file.txt
```

ファイルの所有者とグループをrootに変更します。

```
$ chown root:root file.txt
$ ls -l file.txt 
```

```
-rw-rw-r-- 1 root root 0 Aug 14 00:51 file.txt
```

`ユーザー名:グループ名` ではなく、`ユーザー名.グループ名` でも変更できます。

```
$ chown snorlax.snorlax file.txt
$ ls -l file.txt
```

```
$ -rw-rw-r-- 1 snorlax snorlax 0 Aug 14 00:51 file.txt
```

