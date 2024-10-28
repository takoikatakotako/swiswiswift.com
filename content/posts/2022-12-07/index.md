+++
title = "getent（LPIC）"
url = "2022-12-07"
date = "2022-12-07"
description = "getent（LPIC）"
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

# getent

ネームサービススイッチ（/etc/nsswitch.conf）の設定に従い、引数で指定したデータベースの内容を表示します。


## サンプル

## システムの全ユーザーのアカウントを表示する

```
$ getent passwd
```

```
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/usr/sbin/nologin
...
```
