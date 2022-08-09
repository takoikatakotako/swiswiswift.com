+++
title = "/etc/fstab（LPIC）"
url = "2022-10-18"
date = "2022-10-18"
description = "/etc/fstab（LPIC）"
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

# /etc/fstab

マウントするファイルシステムとマウントポイント、マウント時に指定するオプションなどmountコマンドの実行に必要な情報を記述するファイルです。

## 設定例

```
1        2     3    4         5 6
/dev/sdb /data ext4 user,auto 0 0
```

1. デバイスファイル名（デバイスファイル名、ラベル名、UUID）
2. マウントポイント
3. ファイルシステムの種類 
4. マウントオプション
5. バックアップの指定
6. ファイルシステムのチェック  


## マウントオプション

### async

ファイルシステムの書き込みを非同期で行う

### sync

ファイルシステムの書き込みを同期で行う

### auto

-aふぁ指定された時にマウントされる

### noauto

-aが指定された時にマウントされない

### user

一般ユーザーにマウントを許可する。

