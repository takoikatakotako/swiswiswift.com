+++
title = "traceroute,tracepath（LPIC）"
url = "2022-12-18"
date = "2022-12-18"
description = "traceroute,tracepath（LPIC）"
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

# traceroute


## サンプル

### ローカルホストからswiswiswift.comへの経路をトレースして表示する

```
$ traceroute swiswiswift.com
```

```
traceroute to swiswiswift.com (13.225.173.24), 30 hops max, 60 byte packets
 1  v160-251-100-2.wbeh.static.cnode.io (160.251.100.2)  0.548 ms  0.502 ms  0.473 ms
 2  150.95.5.241 (150.95.5.241)  3.932 ms  3.994 ms  4.078 ms
 3  150.95.5.117 (150.95.5.117)  0.972 ms  0.960 ms  0.948 ms
 4  150.95.5.102 (150.95.5.102)  1.378 ms  1.353 ms  1.326 ms
 5  150.95.5.61 (150.95.5.61)  1.303 ms  1.270 ms 150.95.5.77 (150.95.5.77)  0.861 ms
 6  101.203.88.207 (101.203.88.207)  4.469 ms  3.051 ms as16509-3.ix.jpix.ad.jp (210.171.224.211)  2.031 ms
 7  52.93.66.136 (52.93.66.136)  2.462 ms 52.93.66.40 (52.93.66.40)  1.363 ms 52.93.66.24 (52.93.66.24)  2.169 ms
 8  150.222.77.37 (150.222.77.37)  0.915 ms  0.928 ms  1.046 ms
 9  * * *
10  * * *
11  * * *
12  * * *
13  * * *
14  server-13-225-173-24.nrt57.r.cloudfront.net (13.225.173.24)  0.980 ms  0.888 ms  2.219 ms
```


# tracepath

### ローカルホストからswiswiswift.comへの経路をトレースして表示する

```
$ traceroute swiswiswift.com
```
