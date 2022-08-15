+++
title = "Linuxのファイル（LPIC）"
url = "2022-09-22"
date = "2022-09-22"
description = "Linuxのファイル（LPIC）"
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

# Linuxのファイル

## /etc/apt/sources.list

Debian系のパッケージのダウンロード先（リポジトリ）が書かれたファイル

## /etc/fstab

デバイスとマウントポイント、ファイルシステムについて記述されたファイル

## /etc/passwd

ユーザーのパスワードや属性情報を保存したファイル。現代ではパスワード情報は記載せずに /etc/shadow （シャドウファイル）に分離する運用が一般的となっている。

## /etc/inittab

システム起動後のデフォルトのランレベルが定義されているファイルです。

### /etc/rc[0-6].d or /etc/rc.d/rc[0-6].d

SysV initで起動時に使用するスクリプトをランレベルごとに管理しており、例えばランレベル5であれば /etc/rc.d/rc5.d ディレクトリに格納しています。

## /etc/shadow

ハッシュ化されたパスワードが保存されたファイルです。

## /etc/updatedb.conf

updatedbコマンドの設定が記述されたファイル

## /etc/yum.conf

yumの基本設定ファイル

## /etc/yum.repos.d/

リポジトリサーバーの設定情報が記述されたファイルを保存するディレクトリです。

## /lib64

64bitのPCを使用している際の一般的な共有ライブラリの配置場所です。

## /proc/cpuinfo

プロセッサの情報が格納されたファイルです。

## /proc/cmdline

ブート時にカーネルに渡された引数を確認できるファイルです。

## /proc/interrupts

割り込み要求（IRQ: Interrupt ReQuest）の情報を確認できるファイルです。

## /proc/ioports

## /proc/mounts

現在のマウント状態が格納されているファイル

## /proc.modules

ロードされたモジュールの情報が格納されたファイル

## /proc/self/mounts

現在のマウント状態が格納されているファイル

## /var/log/dmesg

システム立ち上げ時にカーネルが出力するメッセージが格納されているファイル
