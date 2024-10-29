+++
title = "unalias（LPIC）"
url = "2022-09-14"
date = "2022-09-14"
description = "unalias（LPIC）"
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

# unalias

エイリアスを解除するコマンドです。

## サンプル

```
$ alias snorlax='echo Snorlax'
$ snorlax
```

```
Snorlax
```

```
$ unalias snorlax
$ snorlax
```

```
zsh: command not found: snorlax
```
