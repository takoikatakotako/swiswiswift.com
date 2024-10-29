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

## /etc/at.deny

/etc/at.deny に登録されたユーザーは、atコマンドとbatchコマンドの実行を拒否されます。


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

ジョブを追加します。

```
$ at 17:30 today
at Tue Aug 23 17:30:00 2022
at> date > /var/log/at.log
at> <EOT>
$ atq
```

`atq`コマンドでジョブ一覧を表示します。

```
2	Wed Aug 24 17:30:00 2022 a root
```

2番のジョブを削除します。

```
$ at -r 2
```

`atq`コマンドでジョブ一覧を表示します。
2番のジョブが消されていることを確認します。

```
$ atq
```

`atrm`コマンドでもジョブの削除が可能です。

```
$ atrm 2
```


# batch
