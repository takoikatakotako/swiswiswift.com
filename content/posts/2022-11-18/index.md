+++
title = "hwclock（LPIC）"
url = "2022-11-18"
date = "2022-11-18"
description = "hwclock（LPIC）"
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

# hwclock


### ハードウェアクロックをシステムクロックに合わせる

```
$ hwclock -u --systohc
```


### システムクロックをハードウェアクロックに合わせる

```
$ hwclock -u --hctosys
```


