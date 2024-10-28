+++
title = "shutdown（LPIC）"
url = "2022-11-21"
date = "2022-11-21"
description = "shutdown（LPIC）"
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

# shutdown

## オプション

### -r

再起動する。

### -h

シャットダウン後システムを停止する。

### -k

実際にはシャットダウンを行なわず、 ログイン中のユーザ全員へのメッセージ送付のみを行なう。



## サンプル

### 5分後に再起動する

```
$ shutdown -r +5
```

```
Reboot scheduled for Sun 2022-08-14 15:58:19 JST, use 'shutdown -c' to cancel.
```

### ログイン中のユーザ全員へのメッセージを送る

```
$ shutdown now -k "I love snorlax!"
```
