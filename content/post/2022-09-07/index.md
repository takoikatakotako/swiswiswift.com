+++
title = "rpm（LPIC）"
url = "2022-09-07"
date = "2022-09-07"
description = "rpm（LPIC）"
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

# rpm

Red Hat Linux や Fedora linux、CentOS などの Red Hat 系のディストリビューションで採用されているパッケージ管理システムです。
rpmコマンドやyumコマンドを利用してrpmパッケージの管理を行います。


## オプション

### -q, --query

指定したパッケージがインストールされていればバージョンを表示（後述）

### -U, --upgrade

パッケージをアップグレードする。
インストール済みのパッケージが存在しない場合、新規にインストールを行う。

### -F, --freshen

パッケージをアップデートする。
インストール済みのパッケージが存在しない場合、何も行わない。

### -V, --verbose

詳細な情報を表示する

### -h, --hash

進行状況を#記号で表示する

### -e, --erase

パッケージを削除する

### --nodeps

依存関係を無視してパッケージを削除する

### --allmatches

パッケージ名に一致するすべてのバージョンのパッケージを削除する


## query のオプション

### -a, --all

インストール済みのrpmパッケージ情報を一覧で表示

### -i, --info

指定したパッケージの詳細情報を表示

### -c, --configfiles

指定したパッケージ内の設定ファイルのみを表示

### -p, --package

インストールされたrpmパッケージではなく、指定したrpmパッケージファイルの情報を表示

### -R, --requires

指定したパッケージが依存しているrpmパッケージ名を表示


## ファイル名

パッケージファイルのファイル名に規則がある。

### sl-5.02-1.el7.x86_64.rpm

- パッケージ名: sl
- バージョン内容: 5.0.2
- リリース番号: 1.el7
- アーキテクチャ: x86_64（64bit）
- 拡張子: rpm


## サンプル

### インストールされているslコマンドのバージョンを表示

```
$ rpm -q sl
$ rpm --query sl
```

```
sl-5.02-1.el9.x86_64
```

### インストール済みのパッケージ一覧を表示

```
$ rpm -qa
$ rpm --query --all
```

```
...
python3-pytz-2021.1-4.el9.noarch
python3-babel-2.9.1-2.el9.noarch
python3-pyserial-3.4-12.el9.noarch
python3-jsonpointer-2.0-4.el9.noarch
python3-jsonpatch-1.21-16.el9.noarch
python3-distro-1.5.0-7.el9.noarch
...
```


### パッケージが依存するパッケージを表示する

```
$ rpm -qpR sl-5.02-1.el7.x86_64.rpm
```

```
libc.so.6()(64bit)
libc.so.6(GLIBC_2.2.5)(64bit)
libncurses.so.5()(64bit)
libtinfo.so.5()(64bit)
rpmlib(CompressedFileNames) <= 3.0.4-1
rpmlib(FileDigests) <= 4.6.0-1
rpmlib(PayloadFilesHavePrefix) <= 4.0-1
rtld(GNU_HASH)
rpmlib(PayloadIsXz) <= 5.2-1
```


### 設定ファイルを表示する

```
$ rpm -qc bash
$ rpm --query --configfiles bash
```

```
/etc/skel/.bash_logout
/etc/skel/.bash_profile
/etc/skel/.bashrc
```


### インストールされていない場合は新規にインストールし、旧バージョンが存在する場合は更新する

```
$ rpm -U sl-5.02-1.el7.x86_64.rpm
```

### インストールされてされていない場合は何もせず、旧バージョンが存在する場合は更新しる。

```
$ rpm -F sl-5.02-1.el7.x86_64.rpm
```
