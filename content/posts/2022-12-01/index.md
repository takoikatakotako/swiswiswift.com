+++
title = "LPIC101直前まとめ（LPIC）"
url = "2022-12-01"
date = "2022-12-01"
description = "LPIC101直前まとめ（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

# LPIC101直前まとめ

テスト直前に確認することを想定したページです。

### setはシェル変数の一覧を表示するコマンド。シェルのパラメーターも設定できる

### envは環境変数の一覧を表示するコマンド

### pwdは現在のディレクトリパスを表示するコマンド

### $PWDは現在のディレクトリパスが格納された環境変数

### exportは環境変数を設定するコマンド

### manコマンドが実行時に参照するドキュメントファイルは /usr/share/man と /usr/local/share/man に格納されてる

### su - rootはrootでログインし直すコマンド

### mkdirコマンドは-pオプションをつけるとパス途中のディレクトリも作成される

```
$ mkdir -p snorlax/ditto
```

### mvはファイルを移動させるコマンド。-fオプションは移動先にファイルが存在しても強制的に上書きする。*を使うとすべてのファイルを移動する。

```
$ mv -f snorlax/* ditto
```

### cpはファイルをコピーさせるコマンド。-Rオプションはコピー元のディレクトリ構造をそのままコピーする。

```
$ cp -Rf snorlax/* ditto
```

### trはキーボードやファイルから入力された文字を変換して表示するコマンド。小文字を大文字に変換したり、文字を削除したりできる。

```
$ tr -d 'lax' < file.txt 
```

```
Ditto
Sowpoke
Snor
```

```
$ tr 'a-z' 'A-Z' < file.txt 
```

```
DITTO
SLOWPOKE
SNORLAX
```

### wcはテキストファイルの文字数や行数を数えるコマンド

### chownコマンドは指定されたファイルの所有者とグループを変更する

```
$ chown ユーザー名.グループ名 ファイル名
```

### chownコマンドでスティッキービットを指定する場合は「1000」、もしくは「o+t」

### 一時的に利用するライブラリのパスはLD_LIBRARY_PATH環境変数に格納する

### rpmでパッケージファイルを指定して、そのパッケージが依存するパッケージを表示する

```
$ rpm -qpR パッケージファイル名
```

### rpmでインストールzみのパッケージを指定して、そのパッケージに含まれるファイル名リストを表示する

```
$ rpm --query --list
```

### rpmで指定したファイルを含むrpmパッケージを表示する

```
$ rpm -qf /etc/mke2fs.conf
```

### yumでインストール済みパッケージの一覧を表示

```
$ yum list installed
```

### yumコマンドでインストール済みのパッケージを削除する場合はremoveかeraseを使う

### /etc/yum.repos.d にyumのリポジトリの設定が入る

### GRUBの設定ファイルは/boot/grub/menu.lstと/boot/grub/grub.conf

### 起動時にカーネルに渡された引数を確認するには/proc/cmdlineファイルで確認できる

