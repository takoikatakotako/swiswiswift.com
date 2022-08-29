+++
title = "Postfix,Exim,Sendmail,MTA,newaliases,etc（LPIC）"
url = "2022-12-27"
date = "2022-12-27"
description = "Postfix,Exim,Sendmail,MTA,newaliases,etc（LPIC）"
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

# Postfix,Exim,Sendmail,MTA,newaliases,etc


# newaliases

/etc/aliases ファイルを参照して、/etc/aliases.db ファイルを更新するコマンドです。


## ~/.foward

Sendmail, Postfix, Exim などの MTAで、ユーザーが受信メールのリダイレクトを行うファイルです。

```
mama@example.com
mama@mylpic.com
```

## その他
- /etc/aliases ファイルの変更を有効にするには newaliases コマンドを実行します。
