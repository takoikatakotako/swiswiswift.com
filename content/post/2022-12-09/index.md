+++
title = "chronyc,chronyd（LPIC）"
url = "2022-12-09"
date = "2022-12-09"
description = "chronyc,chronyd（LPIC）"
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

# chronyc,chronyd

従来のntpdデーモン、ntpdateコマンドに代わり、機能及びパフォーマンスを改善したものです。
読み方はクローニーです。
設定ファイルは `/etc/chrony.conf` です。


### chronyを起動

```
$ systemctl start chronyd
```
