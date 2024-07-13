+++
title = "GPTとMBR（LPIC）"
url = "2022-11-04"
date = "2022-11-04"
description = "GPTとMBR（LPIC）"
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

# GPTとMBR

MBRとGPTは、マスターブートレコード（Master Boot Record）とGUIDパーティションテーブル（GUID Partition Table）の略語です。


## GPTとMBRの違い

### ブートモードの違い

MBRディスクがBIOSをサポートし、GPTディスクがUEFIをサポートしています。

### サポートするディスク容量が異なる

MBRディスクでは2TBまでの領域しか扱うことができません。
一方でGPTディスクは2TBを超える領域を扱うことができます。


