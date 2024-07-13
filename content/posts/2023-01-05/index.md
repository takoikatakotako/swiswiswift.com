+++
title = "last（LPIC）"
url = "2023-01-05"
date = "2023-01-05"
description = "last（LPIC）"
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

# last

最近ログインしたユーザーのリストを表示するコマンドです。
このコマンドはログイン履歴が記録された `/var/log/wtmp` を参照します。

```
$ last
```

```
root     pts/0        182.170.108.180  Thu Aug 25 12:47   still logged in
root     pts/0        182.170.108.180  Wed Aug 24 23:53 - 01:52  (01:58)
root     pts/0        182.170.108.180  Wed Aug 24 15:54 - 17:06  (01:12)
root     pts/0        182.170.108.180  Wed Aug 24 12:00 - 14:36  (02:35)
root     pts/0        182.170.108.180  Wed Aug 24 00:51 - 03:53  (03:02)
root     pts/0        182.170.108.180  Tue Aug 23 16:08 - 19:55  (03:47)
snorlax  pts/1        182.170.108.180  Tue Aug 23 15:42 - 15:42  (00:00)
snorlax  pts/1        182.170.108.180  Tue Aug 23 15:30 - 15:30  (00:00)
snorlax  pts/1        182.170.108.180  Tue Aug 23 15:21 - 15:21  (00:00)
snorlax  pts/1        182.170.108.180  Tue Aug 23 15:20 - 15:20  (00:00)
snorlax  pts/1        182.170.108.180  Tue Aug 23 15:16 - 15:16  (00:00)
snorlax  pts/1        182.170.108.180  Tue Aug 23 15:12 - 15:12  (00:00)
root     pts/0        182.170.108.180  Tue Aug 23 14:55 - 16:07  (01:11)
snorlax  pts/0        182.170.108.180  Tue Aug 23 12:42 - 12:42  (00:00)
root     pts/0        182.170.108.180  Tue Aug 23 12:13 - 12:41  (00:28)
snorlax  pts/1        182.170.108.180  Mon Aug 22 17:27 - 17:27  (00:00)
snorlax  pts/1        182.170.108.180  Mon Aug 22 17:26 - 17:26  (00:00)
root     pts/0        182.170.108.180  Mon Aug 22 17:00 - 20:09  (03:08)
reboot   system boot  5.15.0-25-generi Mon Aug 22 16:58   still running

wtmp begins Mon Aug 22 16:58:26 2022
```
