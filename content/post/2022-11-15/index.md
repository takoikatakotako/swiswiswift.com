+++
title = "userdel（LPIC）"
url = "2022-11-15"
date = "2022-11-15"
description = "zypper（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

# userdel

ユーザーを削除するコマンドです。


## サンプル

### snorlaxユーザーを削除する（snorlaxのホームディレクトリは残る）

```
$ userdel snorlax
```


### snorlaxユーザーとホームディレクトリを削除する

```
$ userdel -r snorlax
```
