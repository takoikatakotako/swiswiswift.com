+++
title = "chmod（LPIC）"
url = "2022-08-27"
date = "2022-08-27"
description = "chmod（LPIC）"
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

# chmod

ファイルやディレクトリに設定されているパーミッションを変更するコマンドです。


## オプション

### -R

ディレクトリに指定した場合、サブディレクトリを含め再起的にパーミッションが変更される。


## シンボリックモード

文字や記号を用いてパーミッションを指定します。

### ユーザー

- u: 所有者
- g: グループ
- o: その他
- a: すべてのユーザー

### 操作

- +: 許可を与える
- -: 許可を削除する
- =: 許可を設定する

### パーミッション

- r: 読み取り
- w: 書き込み
- x: 実行権


## オクタルモード

数字で権限を指定します。
読み取り権は4、書き込み権は2、実行権は1、権限なしは0と権限を8進数で指定できます。
読み取り、書き込み、実行の権限を与える場合は7、読み取りと書き込みの権限を与える場合は6を設定します。


## サンプル

### シンボリックモードでパーミッションをrwxrwxrwxに変更する

```
$ chmod a=rwx file.txt
```

すべてのユーザーに対するパーミッションを rwx に設定します。

```
$ ls -l file.txt
```

```
-rwxrwxrwx@ 1 snorlax  staff  58  7 31 11:26 file.txt
```


### シンボリックモードでパーミッションをrwxr--r--に変更する

```
$ chmod u=rwx,g=r,o=r file.txt
```

```
$ ls -l file.txt
```

```
-rwxr--r--@ 1 snorlax  staff  58  7 31 11:26 file.txt
```


### オクタルモードでパーミッションをrwxrwxrwxに変更する

```
$ chmod 777 file.txt
```

ユーザーに対するパーミッション、グループに対するパーミッション、その他のユーザーに対するパーミッションをすべて rwx にします。

```
$ ls -l file.txt
```

```
-rwxrwxrwx@ 1 snorlax  staff  58  7 31 11:26 file.txt
```


### オクタルモードでパーミッションをrwxr--r--に変更する

```
$ chmod 744 file.txt
```
rwx は7、rは4なので 744 に設定します。

```
$ ls -l file.txt
```

```
-rwxr--r--@ 1 snorlax  staff  58  7 31 11:26 file.txt
```

### chmodコマンドでSUIDを設定する

SUIDはパーミッションに「4000」もしくは所有者に「s」を付与します。

以下は具体例です。

`snorlax` ユーザーに切り替えます。

```
$ su snorlax
$ id
```

```
uid=1000(snorlax) gid=1000(snorlax) groups=1000(snorlax)
```

`/home/snorlax` に移動し、`snorlax.exe` を作成します。

```
$ cd /home/snorlax
$ touch snorlax.exe
```

`snorlax.exe` の権限はこちらです。

```
$ ls -l snorlax.exe
```

```
-rw-rw-r-- 1 snorlax snorlax 0 Aug  8 00:56 snorlax.exe
```

次に root に切り替えます。

```
$ id
```

```
uid=0(root) gid=0(root) groups=0(root)
```

`/home/snorlax` に移動し、`snorlax.exe` のSUIDを設定します。

```
$ cd /home/snorlax
$ chmod 4664 snorlax.exe
```

```
$ ls -l snorlax.exe
```

```
-rwSrw-r-- 1 snorlax snorlax 0 Aug  8 00:56 snorlax.exe
```

### chmodコマンドでSGIDを設定する

SGIDはパーミッションに「2000」もしくはグループに「s」を付与します。

```
$ chmod 2664 snorlax.exe
```

```
$ ls -l snorlax.exe
```

```
-rw-rwSr-- 1 snorlax snorlax 0 Aug  8 00:56 snorlax.exe
```

### chmodコマンドでスティッキービットを設定する

スティッキービットを設定することで、ファイルの削除、名前の変更をroot以外ができないようにします。
スティッキービットは「1000」もしくは「o+t」を使用します。

```
$ chmod 1000 file.txt
```

