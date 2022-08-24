+++
title = "dig（LPIC）"
url = "2022-12-26"
date = "2022-12-26"
description = "dig（LPIC）"
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

# dig

DNSサーバーへの問い合わせをするコマンドです


### swiswiswift.comのIPアドレスを調べる

```
$ dig swiswiswift.com
```

```
; <<>> DiG 9.18.1-1ubuntu1.1-Ubuntu <<>> swiswiswift.com
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 39724
;; flags: qr rd ra; QUERY: 1, ANSWER: 4, AUTHORITY: 0, ADDITIONAL: 1

;; OPT PSEUDOSECTION:
; EDNS: version: 0, flags:; udp: 65494
;; QUESTION SECTION:
;swiswiswift.com.		IN	A

;; ANSWER SECTION:
swiswiswift.com.	60	IN	A	13.225.173.24
swiswiswift.com.	60	IN	A	13.225.173.42
swiswiswift.com.	60	IN	A	13.225.173.3
swiswiswift.com.	60	IN	A	13.225.173.78

;; Query time: 4 msec
;; SERVER: 127.0.0.53#53(127.0.0.53) (UDP)
;; WHEN: Thu Aug 25 01:29:51 JST 2022
;; MSG SIZE  rcvd: 108
```

`+short` をつけると短くなります。

```
$ dig swiswiswift.com +short
```

```
18.65.185.117
18.65.185.104
18.65.185.82
18.65.185.37
```