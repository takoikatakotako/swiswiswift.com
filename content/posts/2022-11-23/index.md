+++
title = "SysVinit（LPIC）"
url = "2022-11-23"
date = "2022-11-23"
description = "SysVinit（LPIC）"
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

# SysVinit


## SysVinitの起動手順

1. init が /etc/inittab ファイルを読み込む
2. init が /etc/rc.sysinit スクリプトを読み込む
3. init が /etc/rcスクリプトを実行する
4. /etc/rc スクリプトが「/etc/rc<ランレベル>.d」ディレクトリ以下のスクリプトを実行する

