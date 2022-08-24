+++
title = "route（LPIC）"
url = "2022-12-22"
date = "2022-12-22"
description = "route（LPIC）"
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

# route

ルーティングテーブルの設定と表示を行うコマンドです。


### 表示

```
$ route
```

### 追加

```
$ route add { -net | -host } 宛先 [ネットマスク] ゲートウェイ [インターフェース名]
```

### 削除

```
$ route del { -net | -host } 宛先 [ネットマスク] ゲートウェイ [インターフェース名]
```
