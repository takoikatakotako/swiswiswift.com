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

## /etc/passwd

ユーザーのパスワードや属性情報を保存したファイル。現代ではパスワード情報は記載せずに /etc/shadow （シャドウファイル）に分離する運用が一般的となっている。

## /etc/inittab

システム起動後のデフォルトのランレベルが定義されているファイルです。

## /etc/shadow

ハッシュ化されたパスワードが保存されたファイルです。

## /proc/interrupts

## /proc/ioports

## /proc/cpuinfo

## /var/log/dmesg

システム立ち上げ時にカーネルが出力するメッセージが格納されているファイル

## /proc/mounts

現在のマウント状態が格納されているファイル

## /proc/self/mounts

現在のマウント状態が格納されているファイル

