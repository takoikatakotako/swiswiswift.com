+++
title = "umask（LPIC）"
url = "2022-08-28"
date = "2022-08-28"
description = "umask（LPIC）"
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

# umask

デフォルトのパーミッションを決定するumask値を確認、設定するコマンドです。
ファイルの場合は666からumask値を削除したもの、ディレクトリの場合は777からumask値を削除したものがデフォルトのパーミッションになります。


## サンプル

### umask値を確認する

```
$ umask
```

```
022
```


### umask値に027を設定する　

ファイルの場合は666から027を引いたものがパーミッションとなるため、640となり、`rw-r-----` となります。

```
$ umask 027
$ touch file.txt
$ ls -l file.txt
```

```
-rw-r-----  1 snorlax  staff  0  8  2 23:28 file.txt
```

ディレクトリの場合は777から027を引いたものがパーミッションとなるため、750となり、`rwxr-x---` となります。

```
$ umask 027
$ mkdir mydir
$ ls -l file.txt
```

```
drwxr-x--- 2 root root 4096 Aug 16 00:59 mydir
```
