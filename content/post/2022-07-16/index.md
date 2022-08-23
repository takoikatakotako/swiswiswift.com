+++
title = "chsh（LPIC）"
url = "2022-07-16"
date = "2022-07-16"
description = "chsh（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

# chsh


## サンプル


### ユーザーを対話的なログインをできないようにする

sshコマンドによるログインやsuコマンドによるアカウントの変更ができなくなります。

```
$ chsh -s /bin/false snorlax
$ cat /etc/passwd | grep snorlax
```

```
snorlax:x:1000:1000::/home/snorlax:/bin/false
```
