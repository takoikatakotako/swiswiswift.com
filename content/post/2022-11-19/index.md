+++
title = "ntpd,ntpdate,etc（LPIC）"
url = "2022-11-19"
date = "2022-11-19"
description = "ntpd,ntpdate,etc（LPIC）"
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

# ntpd,ntpdate,etc


# ntpd

NTPにより時刻の同期を取るデーモンです。


## /etc/ntp.conf

ntpdの設定ファイルです。


## オプション

### driftfile

### restrict

### server

リモートサーバーのIPアドレスかDNS名、あるいは参照クロックのアドレスを指定する。

### iburst

iburstオプションを指定するとNTPサーバーとの初期の同期時に2秒間隔で8個のパケットを送信して同期を取ります。
通常より早く同期を取ることができます。


### /etc/ntp.conf のサンプル

```
# /etc/ntp.conf, configuration for ntpd; see ntp.conf(5) for help

driftfile /var/lib/ntp/ntp.drift

# Leap seconds definition provided by tzdata
leapfile /usr/share/zoneinfo/leap-seconds.list

# Enable this if you want statistics to be logged.
#statsdir /var/log/ntpstats/

statistics loopstats peerstats clockstats
filegen loopstats file loopstats type day enable
filegen peerstats file peerstats type day enable
filegen clockstats file clockstats type day enable

# Specify one or more NTP servers.

# Use servers from the NTP Pool Project. Approved by Ubuntu Technical Board
# on 2011-02-08 (LP: #104525). See http://www.pool.ntp.org/join.html for
# more information.
pool 0.ubuntu.pool.ntp.org iburst
pool 1.ubuntu.pool.ntp.org iburst
pool 2.ubuntu.pool.ntp.org iburst
pool 3.ubuntu.pool.ntp.org iburst

# Use Ubuntu's ntp server as a fallback.
pool ntp.ubuntu.com

# Access control configuration; see /usr/share/doc/ntp-doc/html/accopt.html for
# details.  The web page <http://support.ntp.org/bin/view/Support/AccessRestrictions>
# might also be helpful.
#
# Note that "restrict" applies to both servers and clients, so a configuration
# that might be intended to block requests from certain clients could also end
# up blocking replies from your own upstream servers.

# By default, exchange time with everybody, but don't allow configuration.
restrict -4 default kod notrap nomodify nopeer noquery limited
restrict -6 default kod notrap nomodify nopeer noquery limited

# Local users may interrogate the ntp server more closely.
restrict 127.0.0.1
restrict ::1

# Needed for adding pool entries
restrict source notrap nomodify noquery

# Clients from this (example!) subnet have unlimited access, but only if
# cryptographically authenticated.
#restrict 192.168.123.0 mask 255.255.255.0 notrust


# If you want to provide time to your local subnet, change the next line.
# (Again, the address is an example only.)
#broadcast 192.168.123.255

# If you want to listen to time broadcasts on your local subnet, de-comment the
# next lines.  Please do this only if you trust everybody on the network!
#disable auth
#broadcastclient
disable monitor
```






# ntpdate

NTPを利用した時刻の設定をするコマンドです。


## サンプル


### システムド系の時刻が正しいか確認する

```
$ ntpdate -q ntp.nict.jp
```

```
24 Aug 16:32:17 ntpdate[81301]: adjust time server 133.243.238.164 offset -0.000001 sec
```


### NTPサーバーに情報通信研究機構（NICT）を指定して時刻を同期する

```
$ ntpdate ntp.nict.jp
```
