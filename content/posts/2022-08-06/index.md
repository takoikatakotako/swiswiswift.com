+++
title = "pgrep（LPIC）"
url = "2022-08-06"
date = "2022-08-06"
description = "pgrep（LPIC）"
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

# pgrep

現在実行中のプロセスを調べて、ユーザー名、UID、GIDなどを元にプロセスIDを検索します。


## オプション

### -u

指定されたユーザーに該当するプロセスIDを検索


## サンプル

### snorlax のプロセスを検索

```
$ pgrep -u snorlax
```

