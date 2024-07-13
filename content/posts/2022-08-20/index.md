+++
title = "Filesystem Hierarcchy Standard（LPIC）"
url = "2022-08-20"
date = "2022-08-20"
description = "Filesystem Hierarcchy Standard（LPIC）"
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

# Filesystem Hierarcchy Standard

Filesystem Hierarcchy Standard（FHS）はディレクトリ構造の標準を定めた仕様書です。


# /

ファイルシステムの頂点にあたるディレクトリ

## /bin

一般ユーザー、管理者が使用するコマンドが配置

## /dev

デバイスファイルが配置。システム起動時に接続されているデバイスがチェックされ、自動的に作成される。

## /etc

システム管理用に設定ファイルや、各種ソフトウェアの設定ファイルが配置。

## /lib

/bin や /sbin などに置かれたコマンドやプログラムが利用する共有ライブラリが配置。

## /lib64

64bit用の共有ライブラリが配置。

## /media

## /opt

Linuxインストール後、追加でインストールしたパッケージが配置。

## /proc

## /root

## /sbin

## /tmp

## /var

### /var/log

## /boot

## /usr

### /usr/bin

### /usr/lib

### /usr/local

Linuxインストール後、追加でインストールしたパッケージ（ソフトウェア）が配置
このディレクトリ以下には bin、sbin、libなどのディレクトリが配置される。

### /usr/sbin

### /home



