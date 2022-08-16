+++
title = "profile、.bash_profile、.profile、.bash_login（LPIC）"
url = "2022-09-11"
date = "2022-09-11"
description = "profile、.bash_profile、.profile、.bash_login（LPIC）"
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

# bash

## /etc/profile、.bash_profile、.bash_login、.profile

`/etc/profile` -> `~/.bash_profile` -> `./bash_login` -> `~/.profile` の順番で読み込まれる。


## .bash_history

`.bash_history` にはコマンド履歴が保存されます。

```
$ cat /root/.bash_history
```

## HISTFILE

`HISTFILE` にはコマンド履歴を保存するファイルが指定されます。

```
$ echo $HISTFILE
```

```
/root/.bash_history
```

## HISTSIZE

```
$ echo $HISTSIZE
```

```
1000
```
