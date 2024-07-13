+++
title = "find（LPIC）"
url = "2022-09-01"
date = "2022-09-01"
description = "find（LPIC）"
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

# find

指定したディレクトリ以下で、指定した検索条件に合致するファイルを検索するコマンドです。


## オプション

### -name

指定したファイル名で検索する

### -type

ファイルのタイプで検索する

### -atime

指定した日時をもとに、最終アクセスがあったファイルを検索する

### -mtime

指定した日時をもとに、最終更新されたファイルを検索する

### -maxdepth

検索するサブディレクトリの深さを指定する


## サンプル

### snorlaxをファイル名に含むファイルを検索する

```
$ find . -name "*snorlax*"
```

### カレントディレクトリのみでsnorlaxをファイル名に含むファイルを検索する

```
$ find . -name "*snorlax*" -maxdepth 1
```

### カレントディレクトリ内のsnorlaxをファイル名に含むファイルを削除する

```
$ find . -name "*snorlax*" -maxdepth 1 -print0 | xargs -0 rm
```

参考: [findとxargsコマンドで-print0オプションを使う理由(改)](https://qiita.com/maskedw/items/2dfdf6fa7eee991ddc45)

### rootが所有するディレクトリとファイルをすべて表示する（-uidを使う場合）

```
$ find . -uid 0
```

rootユーザーのuidは0


### rootが所有するディレクトリとファイルをすべて表示する（-userを使う場合）

```
$ find . -user root
```

### x日前、 x日以上のファイルを検索する

検索対象となるファイルを作成します。

```
$ touch --date="2022/8/4 12:00" 8-4.txt 
$ touch --date="2022/8/5 12:00" 8-5.txt 
$ touch --date="2022/8/6 12:00" 8-6.txt
$ touch --date="2022/8/7 12:00" 8-7.txt 
$ touch --date="2022/8/8 12:00" 8-8.txt 
```

ファイルのタイムスタンプを確認します。

```
$ ls -l
```

```
-rw-r--r-- 1 root root 0 Aug  4 12:00 8-4.txt
-rw-r--r-- 1 root root 0 Aug  5 12:00 8-5.txt
-rw-r--r-- 1 root root 0 Aug  6 12:00 8-6.txt
-rw-r--r-- 1 root root 0 Aug  7 12:00 8-7.txt
-rw-r--r-- 1 root root 0 Aug  8 12:00 8-8.txt
```

現在の時刻を確認します。

```
$ date
```

```
Mon Aug  8 03:48:24 PM JST 2022
```

3日前のファイルを検索します。

```
$ find -mtime 3
```

```
./8-5.txt
```

2日以上前のファイルを検索します。

```
$ find -mtime +2
```

```
./8-4.txt
./8-5.txt
```

2日以内に作成したファイルを検索します。

```
$ find -mtime -2
```

```
./8-8.txt
./8-7.txt
```
