+++
title = "passwd（LPIC）"
url = "2022-09-18"
date = "2022-09-18"
description = "passwd（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

# passwd


## サンプル

### snorlaxのパスワードを設定する

```
$ passwd snorlax
```

### snorlaxのパスワードの有効期限を60日後に設定する

```
$ passwd -x 60 snorlax
$ chage -l snorlax
```

```
Last password change					: Aug 23, 2022
Password expires					: Oct 22, 2022
Password inactive					: never
Account expires						: Aug 24, 2022
Minimum number of days between password change		: 0
Maximum number of days between password change		: 60
Number of days of warning before password expires	: 7
```

### snorlaxのパスワードの有効期限が切れてからアカウントが無効になるまでの期間を30日後に設定する

```
$ passwd -i 30 snorlax
$ chage -l snorlax
```

```
Last password change					: Aug 23, 2022
Password expires					: Oct 22, 2022
Password inactive					: Nov 21, 2022
Account expires						: Aug 24, 2022
Minimum number of days between password change		: 0
Maximum number of days between password change		: 60
Number of days of warning before password expires	: 7
```


### アカウントをロックする

`/etc/shadow` の暗号化されたパスワードの先頭に!を追加します。

```
$ passwd -l snorlax
$ cat /etc/shadow | grep snorlax
```

```
snorlax:!$y$j9T$7Qgxd6njOb7hJJ6PnGtsH0$MHxutns2V446j7twZNlEDVUAfPKV.q62L9T3asDXmv2:19227:0:30:7:15:19228:
```


### アカウントロックを解除する

`/etc/shadow` の暗号化されたパスワードの先頭の!を削除します。

```
$ passwd -u snorlax
$ cat /etc/shadow | grep snorlax
```

```
snorlax:$y$j9T$7Qgxd6njOb7hJJ6PnGtsH0$MHxutns2V446j7twZNlEDVUAfPKV.q62L9T3asDXmv2:19227:0:30:7:15:19228:
```
