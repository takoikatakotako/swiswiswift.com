+++
title = "useradd（LPIC）"
url = "2022-09-17"
date = "2022-09-17"
description = "useradd（LPIC）"
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

# useradd,usermod,userdel

ユーザーを追加したり、削除したりするコマンドです。



# useradd

ユーザーを追加するためのコマンドです。
似たコマンドにadduserコマンドがあります。


## オプション

### -c

コメントを指定

### -e

アカウント失効日の指定

### -m

ホームディレクトリを作成する


## サンプル

### snorlaxユーザーを作成する

```
$ useradd snorlax
```

### snorlaxユーザーをホームディレクトリ付きで作成する

ユーザー作成時に `/etc/skel` 以下にあるものがコピーされます。

```
$ useradd -m snorlax
$ ls /home
```

```
snorlax
```


### snorlaxユーザーをコメント付きで作成する

```
$ useradd -c 'I love snorlax!' snorlax
$ cat /etc/passwd | grep snorlax
```

```
snorlax:x:1000:1000:I love snorlax!:/home/snorlax:/bin/sh
```

### snorlaxユーザーを失効日付きで作成する

2022年8月24日になるとログインできなくなります。

```
$ useradd -e 8/24/2022 snorlax
$ passwd snorlax    # パスワードを入力
$ chage -l snorlax
```

```
Last password change					: Aug 23, 2022
Password expires					: never
Password inactive					: never
Account expires						: Aug 24, 2022
Minimum number of days between password change		: 0
Maximum number of days between password change		: 99999
Number of days of warning before password expires	: 7
```


# usermod

ユーザー情報を変更するコマンドです。

## サンプル

### ユーザーをグループに追加する

```
$ groupadd pokemon
$ usermod -aG pokemon snorlax
$ groups snorlax
```

```
snorlax : snorlax pokemon
```

### ユーザーを対話的なログインをできないようにする

sshコマンドによるログインやsuコマンドによるアカウントの変更ができなくなります。

```
$ usermod -s /sbin/nologin snorlax
$ cat /etc/passwd | grep snorlax
```

```
snorlax:x:1000:1000::/home/snorlax:/sbin/nologin
```

### アカウントをロックする

`/etc/shadow` の暗号化されたパスワードの先頭に`!`を追加してロックします。

```
$ usermod -L snorlax
$ cat /etc/shadow | grep snorlax
```

```
snorlax:!$y$j9T$7Qgxd6njOb7hJJ6PnGtsH0$MHxutns2V446j7twZNlEDVUAfPKV.q62L9T3asDXmv2:19227:0:30:7:15:19228:
```

### アカウントをアンロックする

`/etc/shadow` の暗号化されたパスワードの先頭の`!`を削除してアンロックします。

```
$ usermod -U snorlax
$ cat /etc/shadow | grep snorlax
```

```
snorlax:$y$j9T$7Qgxd6njOb7hJJ6PnGtsH0$MHxutns2V446j7twZNlEDVUAfPKV.q62L9T3asDXmv2:19227:0:30:7:15:19228:
```


# userdel

ユーザーを削除するコマンドです。

## サンプル

### snorlaxユーザーを削除する

```
$ userdel snorlax
```

### snorlaxユーザーとホームディレクトリを削除する

```
$ userdel -r snorlax
$ ls /home
```

同様に以下のコマンドでも削除できる

```
$ userdel --force --remove snorlax
```



