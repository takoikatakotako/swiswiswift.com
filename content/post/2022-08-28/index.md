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
666からumask値を削除したものがデフォルトのパーミッションになります。
umask値が022の場合、パーミッションは644となります。


## サンプル

### umask値を確認する

```
$ umask
```

```
022
```


### umask値に027を設定する　

```
$ umask 027
$ touch file.txt
$ ls -l file.txt
```

```
-rw-r-----  1 snorlax  staff  0  8  2 23:28 file.txt
```

666から027を引いたものは640となり、`rw-r-----` となります。
