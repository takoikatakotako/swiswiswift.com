+++
title = "stat（LPIC）"
url = "2022-10-23"
date = "2022-10-23"
description = "stat（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

# stat

ファイルやディレクトリの属性や日付、iノード番号などを表示するコマンドです。


## サンプル

###

```
$ stat file.txt
```

```
16777222 84363776 -rw-r--r-- 1 snorlax staff 0 10 "Aug  9 17:56:08 2022" "Aug  9 17:56:06 2022" "Aug  9 17:56:06 2022" "Aug  9 17:56:06 2022" 4096 8 0 file.txt
```
