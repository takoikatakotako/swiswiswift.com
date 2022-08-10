+++
title = "特殊文字のエスケープ（LPIC）"
url = "2022-10-26"
date = "2022-10-26"
description = "特殊文字のエスケープ（LPIC）"
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

# xargs

標準入力から受け取った値を引数に渡すコマンドです。


## サンプル

### ls に '-li' を渡して実行する

`ls -li` と同等です。

```
$ echo '-li' | xargs ls
```
