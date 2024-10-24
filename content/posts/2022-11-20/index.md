+++
title = "journalctl（LPIC）"
url = "2022-11-20"
date = "2022-11-20"
description = "journalctl（LPIC）"
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

# journalctl

systemd-journaldが収集したログを表示するためのコマンドです。


## サンプル

### 保管されている一番古いログから順番に確認する

```
$ journalctl
```

```
Aug 13 00:05:00 localhost kernel: Linux version 5.14.0-39.el9.x86_64 (mockbuild@x86-03.stream.rdu2.redhat.com) (gcc (GCC) 11.2.1 20211019 (Red Hat 11.2.1-6), GNU ld version 2.35.2-13.el9) #1 SMP PREEMPT Fri Dec 24 04:03:40 UTC 2021
Aug 13 00:05:00 localhost kernel: Command line: BOOT_IMAGE=(hd0,gpt2)/boot/vmlinuz-5.14.0-39.el9.x86_64 root=UUID=4683850f-07fa-4ac1-96ff-4ae48affa2ba ro crashkernel=1G-4G:192M,4G-64G:256M,64G-:512M rhgb quiet net.ifnames=0 console=tty0 console=ttyS0,115200n8r
Aug 13 00:05:00 localhost kernel: x86/fpu: Supporting XSAVE feature 0x001: 'x87 floating point registers'
Aug 13 00:05:00 localhost kernel: x86/fpu: Supporting XSAVE feature 0x002: 'SSE registers'
Aug 13 00:05:00 localhost kernel: x86/fpu: Supporting XSAVE feature 0x004: 'AVX registers'
...
```


### 最新のログから過去にさかのぼってログを確認する

```
$ journalctl -r
```

```
Aug 14 15:46:26 133-130-108-39 sshd[110136]: Disconnected from 61.177.172.19 port 12992 [preauth]
Aug 14 15:46:26 133-130-108-39 sshd[110136]: Received disconnect from 61.177.172.19 port 12992:11:  [preauth]
Aug 14 15:46:23 133-130-108-39 NetworkManager[668]: <info>  [1660459583.1230] policy: set-hostname: current hostname was changed outside NetworkManager: '133-130-108-39'
Aug 14 15:45:59 133-130-108-39 NetworkManager[668]: <info>  [1660459559.1221] policy: set-hostname: current hostname was changed outside NetworkManager: '133-130-108-39'
Aug 14 15:45:46 133-130-108-39 NetworkManager[668]: <info>  [1660459546.1296] policy: set-hostname: current hostname was changed outside NetworkManager: '133-130-108-39'
...
```
