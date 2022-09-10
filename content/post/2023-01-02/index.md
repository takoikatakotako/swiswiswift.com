+++
title = "systemdのタイマー（LPIC）"
url = "2023-01-02"
date = "2023-01-02"
description = "systemdのタイマー（LPIC）"
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

# systemdのタイマー

cronのようなタイマーを作ることができます。

## 1時間ごとに実行するタイマーを作成する

スクリプト `timer-per-hour.sh` を作成します。

```
$ vi /usr/local/bin/timer-per-hour.sh
```

以下のような内容を記述します。

```
#!/bin/bash
date >> /var/log/timer-per-housr.log
```

権限を付与します。

```
$ chmod 755 /usr/local/bin/timer-per-hour.sh
```

`timer-per-hour.timer` を作成します。

```
$ vi /etc/systemd/system/timer-per-hour.timer
```

```
[Unit]
Description="Per hour"

[Timer]
OnActiveSec=1hour
OnUnitActiveSec=1hour
Unit=timer-per-hour.service

[Install]
WantedBy=multi-user.target
```

```
$ systemctl enable timer-per-hour.timer
```

```
$ systemctl list-timers
```


## サンプル

### 登録されているタイマーの一覧を表示

```
$ systemctl list-timers
```

```dotnetcli
NEXT                        LEFT          LAST                        PASSED        UNIT                           ACTI>
Wed 2022-08-24 17:03:43 JST 58min left    Tue 2022-08-23 17:03:43 JST 23h ago       update-notifier-download.timer upda>
Wed 2022-08-24 17:13:48 JST 1h 8min left  Tue 2022-08-23 17:13:48 JST 22h ago       systemd-tmpfiles-clean.timer   syst>
...
```
