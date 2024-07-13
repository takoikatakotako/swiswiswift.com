+++
title = "systemctl（LPIC）"
url = "2022-11-08"
date = "2022-11-08"
description = "systemctl（LPIC）"
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

# systemctl

## サンプル

### sshd.serviceを開始する

```
$ systemctl start sshd.service
```

### システム起動時にsshd.serviceを自動起動する

```
$ systemctl enable sshd.service
```



