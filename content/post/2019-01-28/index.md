+++
title = "id_rsa’ are too open."
url = "2019-01-28"
date = "2019-01-28"
description = "Guide to emoji usage in Hugo"
tags = [
    "iOS",
]
categories = [
    "themes",
    "syntax",
]
archives = "2019/09"
aliases = ["migrate-from-jekyl"]
+++

<br>
以下のエラーが出てssh接続ができなくなりました。
原因は秘密鍵の権限を制限してあげることで解決しました。

```
WARNING: UNPROTECTED PRIVATE KEY FILE! @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Permissions 0777 for '/root/.ssh/id_rsa' are too open.
It is recommended that your private key files are NOT accessible by others.
This private key will be ignored.
bad permissions: ignore key: /root/.ssh/id_rsa

$ chmod 600 /root/.ssh/id_rsa
```

参考　Error permission denied through ssh
