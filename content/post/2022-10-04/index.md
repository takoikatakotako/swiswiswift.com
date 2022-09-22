+++
title = "lsusb（LPIC）"
url = "2022-10-04"
date = "2022-10-04"
description = "lsusb（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

# lsusb

USBバスと、接続されているデバイスに関する情報を表示します。


```
$ lsusb
```

```
Bus 001 Device 002: ID 0627:0001 Adomax Technology Co., Ltd QEMU USB Tablet
Bus 001 Device 001: ID 1d6b:0001 Linux Foundation 1.1 root hub
```


```
$ lsusb -t
```

```
/:  Bus 01.Port 1: Dev 1, Class=root_hub, Driver=uhci_hcd/2p, 12M
    |__ Port 1: Dev 2, If 0, Class=Human Interface Device, Driver=usbhid, 12M
```
