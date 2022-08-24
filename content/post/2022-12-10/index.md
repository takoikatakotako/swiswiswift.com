+++
title = "syslogd（LPIC）"
url = "2022-12-10"
date = "2022-12-10"
description = "syslogd（LPIC）"
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

# syslogd



## /etc/syslog.conf

syslogdの設定ファイルです。


## すべてのカーネルメッセージをコンソールに表示する

```
kern.* /dev/console
```
