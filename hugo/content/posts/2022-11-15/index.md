+++
title = "userdel（LPIC）"
url = "2022-11-15"
date = "2022-11-15"
description = "zypper（LPIC）"
tags = ["Linux", "LPIC"]
categories = ["Linux"]
archives = "2022/11"
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
