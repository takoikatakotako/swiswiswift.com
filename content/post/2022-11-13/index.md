+++
title = "at,batch（LPIC）"
url = "2022-11-13"
date = "2022-11-13"
description = "at,batch（LPIC）"
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

# at,batch

指定したコマンドを1回だけ実行するコマンドです。


# at


## /etc/at.allow

/etc/at.allow に登録されたユーザーは、atコマンドとbatchコマンドの実行を許可されます。


## サンプル

### 今日の17:30に/var/log/at.logにログを出力する

```
$ at 17:30 today
at Tue Aug 23 17:30:00 2022
at> date > /var/log/at.log
at> <EOT>
```


### キューに入っている実行待ちのジョブを表示

```
$ atq
```

```
1	Tue Aug 23 17:30:00 2022 a root
```

### キューに入っている実行待ちジョブを削除

```
$ at -r
```

```
$ atrm
```


# batch
