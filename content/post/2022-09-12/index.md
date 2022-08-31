+++
title = "SSHキーを設定する（LPIC）"
url = "2022-09-12"
date = "2022-09-12"
description = "SSHキーを設定する（LPIC）"
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

# SSHキーを設定する

サーバー側で鍵を生成し、クライアント側にダウンロードする方法です。
ubuntuでの設定方法です。

## sshでサーバーにログインする

sshでサーバーにログインします。

```
$ ssh root@example.com
```

## 鍵を作成する

rsa形式で鍵を作成します。
`~/.ssh/id_rsa.pub`、`~/.ssh/id_rsa` に公開鍵、秘密鍵が書き出されます。

```
$ ssh-keygen -t rsa
```

## 秘密鍵をクライアント側にダウンロードする

秘密鍵をクライアント側にダウンロードします。

```
$ scp root@160.251.101.197:/root/.ssh/id_rsa .
```

ダウンロードが完了したら秘密鍵を削除します。

```
$ rm /root/.ssh/id_rsa
```

## 鍵を設定する

公開鍵を `authorized_keys` に追加し、`id_rsa.pub` を削除します。

```
$ cat id_rsa.pub >> authorized_keys
$ chmod 600 authorized_keys
$ rm id_rsa.pub
```

## サーバー側sshd設定変更

秘密鍵によるログインを有効にします。

```
$ vi /etc/ssh/sshd_config
```

```
AuthorizedKeysFile      .ssh/authorized_keys .ssh/authorized_keys2
```

```
$ systemctl restart sshd.service
```

## クライアント側からsshする

鍵を指定してログインします。

```
$ ssh -i id_rsa root@example.com
```
