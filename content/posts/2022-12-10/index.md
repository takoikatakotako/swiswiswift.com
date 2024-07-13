+++
title = "syslog,rsyslog,syslog-ng,systemd journal,logger,etc（LPIC）"
url = "2022-12-10"
date = "2022-12-10"
description = "syslog,rsyslog,syslog-ng,systemd journal,logger,etc（LPIC）"
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

# syslog,rsyslog,syslog-ng,systemd journal

システムログを収集するソフトウェアです。


# syslog


## ファシリティ

ファシリティはメッセージの生成元を表します。

- kern: カーネルによる出力
- user: ユーザアプリケーションによる出力
- mail: メールサービス関連による出力
- daemon: システムデーモンによる出力


## プライオリティ

プライオリティはメッセージの重要度を表します。

- emerg: パニック状態でシステムは使用不能
- alert: 緊急に対処が必要
- crit: 緊急に対処が必要。alertよりは緊急度は低い
- err: エラー発生
- debug: デバッグ情報
- none: ログメッセージを記録しない。

`etcsyslog.conf` ファイルで `kern.crit` と設定すると crit以上のすべてのメッセージが `/var/log/messages` に記録される。



## /etc/syslog.conf

syslogdの設定ファイルです。


## すべてのカーネルメッセージをコンソールに表示する

```
kern.* /dev/console
```


# rsyslog

Syslogプロトコルをベースとして作成されました。
設定ファイル rsyslog.conf は syslog の設定ファイル syslog.conf と後方互換性があります。


# syslog-ng

設定ファイルである syslog-ng.conf は。syslog の設定ファイル syslog.conf とは書式が異なるため互換性がありません。


# systemd journal

systemdを採用するシステムでシステムを収集するプログラムです。
rsyslogなどの他のsyslogソフトウェアと連携することができます。

### /var/log/journal

不揮発性ストレージを使う場合（デフォルト）は /var/log/journal に保存される。

### /run/log/journal

揮発性ストレージを使う場合は /run/log/journal に保存される。


## サンプル


### 2022年8月28日以降のログを取得

```
$ journalctl --since="2022-08-28 00:00:00"
```

### 2022年8月28日以前のログを取得

```
$ journalctl --until="2022-08-28 00:00:00"
```


# systemd-cat

メッセージをログに記録するコマンドです。

```
$ systemd-cat echo "snorlax"
$ cat /var/log/syslog | grep snorlax
```

```
Aug 26 15:23:32 160-251-101-197 echo[103620]: snorlax
Aug 26 15:26:06 160-251-101-197 echo[103657]: snorlax
```


# logger

## -f

指定したファイルの内容を送信する

## -p

ファシリティ、プライオリティを指定する。

### Kabigonとログに出力する

```
$ logger "Kabigon"
$ cat /var/log/syslog | grep Kabigon
```

```
Aug 26 15:31:26 160-251-101-197 root: Kabigon
```


# logrotate

ログローテーションを行うコマンドです。
`/etc/logrotate.conf` が設定ファイルです。

### /etc/logrotate.confを指定してlogrotateコマンドを実行する

```
$ logrotate /etc/logrotate.conf
```
