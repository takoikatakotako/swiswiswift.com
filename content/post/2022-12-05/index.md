+++
title = "cron,crontab,anacron,etc（LPIC）"
url = "2022-12-05"
date = "2022-12-05"
description = "cron,crontab,anacron,etc（LPIC）"
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

# cron,crontab,anacron,etc







# cron

# crontab

## /etc/cron.allow, /etc/cron.deby

`/etc/cron.allow` に記述があるユーザーはcrontabを作成することができる。
`/etc/cron.deby` に記述があるユーザーはcrontabを作成することができない。
`/etc/cron.allow` と `/etc/cron.deby` の両方が作成されている場合は
`/etc/cron.allow` と `/etc/cron.deby` の両方が存在しない場合はrootユーザーだけがcrontabを作成できる。

```
1 2 3 4 5 6
* * * * * *
```

- 1. 分
- 2. 時
- 3. 日
- 4. 月
- 5. 曜日
- 6. コマンド


## ユーザーのcrontabファイル

ユーザーのcrontabファイルは `/var/spool/cron/crontabs/` に格納されます。
rootの場合は `/var/spool/cron/crontabs/root` に格納されます。


## /etc/cron.allow

`/etc/cron.allow` がある場合、ファイルに記述されているユーザーがcronを利用できる。


## /etc/cron.deby

`/etc/cron.deby` がある場合、ファイルに記述されていないユーザーがcronを利用できる。


## サンプル

### 毎分/var/log/cron.logにhelloと追記する

```
$ crontab -e
```

```
* * * * * /usr/bin/echo "hello" >> /var/log/cron.log 2>&1
```


### crontabを表示する

```
$ crontab -l
```



### crontabを削除する

```
$ crontab -r
```



# anacron

`/etc/cron.daily`、`/etc/cron.weekly`、`/etc/cron.monthly` ディレクトリ以下に置かれているコマンドを実行します。
`/etc/crontab` で定義されています。

```
# /etc/crontab: system-wide crontab
# Unlike any other crontab you don't have to run the `crontab'
# command to install the new version when you edit this file
# and files in /etc/cron.d. These files also have username fields,
# that none of the other crontabs do.

SHELL=/bin/sh
# You can also override PATH, but by default, newer versions inherit it from the environment
#PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin

# Example of job definition:
# .---------------- minute (0 - 59)
# |  .------------- hour (0 - 23)
# |  |  .---------- day of month (1 - 31)
# |  |  |  .------- month (1 - 12) OR jan,feb,mar,apr ...
# |  |  |  |  .---- day of week (0 - 6) (Sunday=0 or 7) OR sun,mon,tue,wed,thu,fri,sat
# |  |  |  |  |
# *  *  *  *  * user-name command to be executed
17 *	* * *	root    cd / && run-parts --report /etc/cron.hourly
25 6	* * *	root	test -x /usr/sbin/anacron || ( cd / && run-parts --report /etc/cron.daily )
47 6	* * 7	root	test -x /usr/sbin/anacron || ( cd / && run-parts --report /etc/cron.weekly )
52 6	1 * *	root	test -x /usr/sbin/anacron || ( cd / && run-parts --report /etc/cron.monthly )
#
```

