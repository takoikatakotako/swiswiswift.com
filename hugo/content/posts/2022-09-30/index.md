+++
title = "uniq（LPIC）"
url = "2022-09-30"
date = "2022-09-30"
description = "uniq（LPIC）"
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

# uniq

重複する内容の行を1行にまとめることができます。
ソートされていない場合は事前にソートする必要があります。


## サンプル

### file.txtの重複する行を1行にまとめる

```
$ cat file.txt
```

```
Ditto
Ditto
Snorlax
Snorlax
Snorlax
Slowpoke
Slowpoke
```

```
$ cat file.txt | uniq
```

```
Ditto
Snorlax
Slowpoke
```

### sort後にuniqを使う

file.txtが以下のようにソートされていない場合、uniqコマンドだけではまとめることができません。

```
Ditto
Slowpoke
Snorlax
Snorlax
Snorlax
Ditto
Ditto
Snorlax
Slowpoke
Snorlax
Ditto
Slowpoke
Ditto
```


```
$ cat file.txt | uniq
```

```
Ditto
Slowpoke
Snorlax
Ditto
Snorlax
Slowpoke
Snorlax
Ditto
Slowpoke
Ditto
```

事前にファイルの内容をソートしてからuniqコマンドでまとめる必要があります。

```
$ cat file.txt | sort | uniq
```

`````
Ditto
Slowpoke
Snorlax
```
