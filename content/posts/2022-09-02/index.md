+++
title = "locate,updatedb（LPIC）"
url = "2022-09-02"
date = "2022-09-02"
description = "locate,updatedb（LPIC）"
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

# locate,updatedb

locateはファイルを名前で検索するコマンドです。
updatedbはlocate用の検索データベースを作成します。


## サンプル

### snorlaxをファイル名に含むファイルを検索する

```
$ find . -name snorlax
```

