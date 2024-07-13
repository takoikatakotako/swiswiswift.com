+++
title = "複数の画像をpdfに変換する"
url = "2022-10-15"
date = "2022-10-15"
description = "複数の画像をpdfに変換する"
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

複数の画像をpdfに変換する方法です。
ImageMagicがインストールされていない場合はインストールします。
Macの場合はbrewでインストールすると楽だと思います。

```
$ convert ./images/*.PNG 102-chap1.pdf
```
