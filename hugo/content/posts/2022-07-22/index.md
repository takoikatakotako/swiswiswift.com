+++
title = "less（LPIC）"
url = "2022-07-22"
date = "2022-07-22"
description = "less（LPIC）"
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

# less

`less` は1画面に収まらないような長いテキストを表示するために使うコマンドです。
似たコマンドに `more` があります。
末尾まで行くと自動的にプロンプトへ戻るのが `more`、戻らないのが `less` です。

## サンプル

### file.txt　を表示する

```
$ less file.txt
```

[Space]キーを押すと次のページが表示されます。
