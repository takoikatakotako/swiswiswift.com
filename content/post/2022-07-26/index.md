+++
title = "コマンドを続けて実行する（LPIC）"
url = "2022-07-26"
date = "2022-07-26"
description = "コマンドを続けて実行する（LPIC）"
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

# コマンドを続けて実行する

複数のコマンドを続けて実行する方法です。


## サンプル

### ;の前のコマンドの終了コードに関わらずコマンドを順々に実行する

```
$ snorlax ; ls
```

### &&の前のコマンドの終了コードが0ならば&&の後のコマンドを実行する

```
$ mkdir snorlax ; ls
```


### ||の前のコマンドの終了コードが0以外ならば||の後のコマンドを実行する

```
$ snorlax ; ls
```
