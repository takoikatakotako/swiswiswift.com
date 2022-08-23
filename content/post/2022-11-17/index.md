+++
title = "chage（LPIC）"
url = "2022-11-17"
date = "2022-11-17"
description = "chage（LPIC）"
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

# change

## サンプル

### snorlaxユーザーのパスワードの有効期限を調べる

```
$ chage -l snorlax
```




### snorlaxのパスワードの有効期限を30日後に設定する

```
$ chage -M 30 snorlax
$ chage -l snorlax
```

```
Last password change					: Aug 23, 2022
Password expires					: Sep 22, 2022
Password inactive					: Dec 31, 2022
Account expires						: Aug 24, 2022
Minimum number of days between password change		: 0
Maximum number of days between password change		: 30
Number of days of warning before password expires	: 7
```

### snorlaxのパスワードの有効期限が切れてからアカウントが無効になるまでの期間を15日後に設定する

```
$ chage -I 15 snorlax
$ chage -l snorlax
```

```
Last password change					: Aug 23, 2022
Password expires					: Sep 22, 2022
Password inactive					: Oct 07, 2022
Account expires						: Aug 24, 2022
Minimum number of days between password change		: 0
Maximum number of days between password change		: 30
Number of days of warning before password expires	: 7
```

