+++
title = "yum（LPIC）"
url = "2022-09-08"
date = "2022-09-08"
description = "yum（LPIC）"
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

# yum


### yum update と yum upgrade の違い

`yum update` はインストール済みのパッケージをアップデートするコマンドです。
`yum upgrade` は `yum update --obsoletes` と同じです。
`--obsoletes` は、パッケージの更新時にのみ有効なオプションで、不要になったパッケージの削除を自動で行います。


## /etc/yum.conf

yumの基本設定ファイルです。

```
$ cat 
```

```
[main]
gpgcheck=1
installonly_limit=3
clean_requirements_on_remove=True
best=True
skip_if_unavailable=False
```

## /etc/yum.repos.d/

リポジトリサーバーの設定情報が記述されたファイルを保存するディレクトリです。

```
$ ls /etc/yum.repos.d/
```

```
centos-addons.repo  centos.repo  epel-next.repo  epel-next-testing.repo  epel.repo  epel-testing.repo  redhat.repo
```


## サンプル

### slコマンドをインストールする

```
$ yum install sl
```

### パッケージグループを一覧表示する

```
$ yum grouplist
```

### インストール済みのパッケージの一覧を表示

```
$ yum list installed
```

### アップデートができるすべてのパッケージを表示

```
$ yum list updates
$ yum check-update
```

### インストール済みのrpmパッケージをyumコマンドで削除

```
$ yum remove sl
$ yum erase sl
```


