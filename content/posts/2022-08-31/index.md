+++
title = "ln（LPIC）"
url = "2022-08-31"
date = "2022-08-31"
description = "ln（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

# ln

ファイルへのリンクを作成するコマンドです。


## ハードリンクとシンボリックリンクの違い

複数の実名を付ける処理がハードリンクです。
ハードリンクの場合、複数あるファイル名はどれも対等なものとなります。
ただしハードリンクは異なるディレクトリ間で作成することはできません。
シンボリックリンクは別名を付けることに相当します。
シンボリックリンクを作成すると新たにファイルが生成され、リンク先のファイル名とパスが保持されます。

具体例で説明します。
まずはファイルを作成します。

```
$ touch file.txt
```

ファイルの詳細を確認します。

```
$ ls -li file.txt
```

```
393491 -rw-r--r-- 1 root root 0 Aug  8 01:38 file.txt
```

ハードリンクを作成します。

```
$ ln file.txt file-hard.txt
```

2つのファイルの詳細を確認します。

```
$ ls -li file.txt
$ ls -li file-hard.txt
```

```
393491 -rw-r--r-- 2 root root 0 Aug  8 01:38 file.txt
393491 -rw-r--r-- 2 root root 0 Aug  8 01:38 file-hard.txt
```

ハードリンクではiノードの値が共に `393491` であることがわかります。
またハードリンクを作成したことで、リンク数が1から2へと増えていることがわかります。

次にシンボリックリンクを作成します。

```
$ ln -s file.txt file-symbolic.txt
```

2つのファイルの詳細を確認します。

```
$ ls -li file.txt
$ ls -li file-symbolic.txt
```

```
83849756 -rw-r--r--  3 snorlax  staff  0  8  4 11:41 file.txt
83850154 lrwxr-xr-x  1 snorlax  staff  8  8  4 11:46 file-symbolic.txt -> file.txt
```

このようにシンボリックリンクはオリジナルファイルの位置情報を保管している別ファイルとして作成されるため、iノード番号も別に割り当てられます。
またパーミッションの先頭は、ファイルタイプとしてシンボリックリンクを表す「l」が表示されています。


## サンプル

### ハードリンクを作成する

```
$ ln file.txt file.txt-link
```

```
$ echo "snorlax" > file.txt
$ cat file.txt-link
```

```
snorlax
```


### シンボリックリンクを作成する

```
$ ln -s file.txt file.txt-link
```

```
$ echo "snorlax" > file.txt
$ cat file.txt-link
```

```
snorlax
```
