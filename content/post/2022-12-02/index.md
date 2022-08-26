+++
title = "X.org（LPIC）"
url = "2022-12-02"
date = "2022-12-02"
description = "X.org（LPIC）"
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

# X.org,etc


## xorg.conf

設定ファイルです。


## ディスプレイマネージャー

- XDM（X Display Manager）
- GDM（Gnome Display Manager）
- SDDM（Simple Desktop Display Manager）
- LightDM


## ウィンドウマネージャー

- Mutter
- metacity
- kwin


## デスクトップ環境

## GNOME（GNU Network Object Model Environment）

- 標準ディスプレイマネージャー: gdm
- 標準ウィンドウマネージャー: metacity, mutter


## KDE

- 標準ディスプレイマネージャー: kdm, sddm
- 標準ウィンドウマネージャー: kwin


## X Window System

- 標準ディスプレイマネージャー: xdm
- 標準ウィンドウマネージャー: twm


## アクセシビリティ

### オンスクリーンキーボード

- gok（GNOME Onscreen Keyboard）はGonome2のオンスクリーンキーボード

### テキスト読み上げプログラム

- emacspeakはEmacsに読み込んだテキストや電子メールなどを音声を読み上げるソフトです。

### スティッキー・キー

2つのキーを同時に起こすことが困難な場合に有効にする設定です。

### スロー・キー

指定した時間より長く押し続けないとそのキー入力を有効としない設定です。

### バウンス・キー

同じキーを素早く押したとき場合はそのキー入力を有効としない設定です。

## xdpyinfo

Xサーバーについての情報を表示するコマンドです。

## xwininfo

クリックした特定のウィンドウの情報を表示するコマンドです。


## 環境変数DISPLAY

Xのアプリケーションは環境変数DISPLAYで指定されたディスプレイを表示します。


## xhost



## xなんとかを動かす


MacにXquartzをインストールする

https://www.xquartz.org/


## CentOS編


yum update
yum upgrade


xorgをインストールする

yum install -y xorg-x11-xauth.x86_64 xorg-x11-server-utils.x86_64


xeyesをインストール

yum install xeyes



https://qiita.com/shirok/items/9f55879bb3facf89082f




## Ubuntu


apt-get update
apt-get upgrade


apt-get -y install xserver-xorg
apt-get -y install x11-apps


vi /etc/ssh/sshd_config

X11Forwarding yes
X11DisplayOffset 10
X11UseLocalhost no

cat /etc/ssh/sshd_config | grep X11


ufw allow 6000
ufw reload
ufw status



ssh -XY root@xxxxxxxx


xeyes
xcalc
xclock





https://blog.amedama.jp/entry/ubuntu-2004-install-gui

https://qiita.com/kkk627/items/42e6280a02338fa62700


[X11 ForwardingしてMacにGUI表示する](https://qiita.com/loftkun/items/37340745f211ea5d7ece)




vpn


apt-get install -y xfce4 xfce4-goodies

apt-get install -y tightvncserver

vncserver

93J$bv4CTuFf





vncserver -kill :1



command + k

ssh -L 59000:localhost:5901 -C -N -l root 160.251.78.167



vnc://localhost:59000



[UbuntuにVNCサーバーを構築してMacからリモート接続するための備忘録](https://qiita.com/y-vectorfield/items/64a332c9e632bcd8f762)








