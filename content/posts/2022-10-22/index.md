+++
title = "変数の展開（LPIC）"
url = "2022-10-22"
date = "2022-10-22"
description = "変数の展開（LPIC）"
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

# 変数の展開

## ダブルクオート内で変数を展開する

```
$ echo "I am ${USER}."
```

```
I am snorlax.
```

鉤括弧を使わなくても変数を展開できます。

```
$ echo "I am $USER."
```

```
I am snorlax.
```

シングルクオートでは変数は展開されません。

```
$ echo 'I am ${USER}.'
```

```
I am ${USER}.
```
