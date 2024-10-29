+++
title =  "ターミナルのアカウント名を一時的に変更する"
url = "2022-04-10"
date = "2022-04-10"
description = "ターミナルのアカウント名を一時的に変更する"
tags = [
  "Terminal"
]
categories = [
  "Terminal"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

ターミナルのアカウント名を一時的に変更する方法です。
以下のコマンドで一時的にアカウント名を変えることができます。

```
$ export PS1="snorlax %# "
```

カレントディレクトリを表示する場合は `%1~` を使います。

```
$ export PS1="%1~ %# "
```
