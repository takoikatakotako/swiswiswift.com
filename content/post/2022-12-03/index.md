+++
title = "/etc/passwd（LPIC）"
url = "2022-12-03"
date = "2022-12-03"
description = "/etc/passwd（LPIC）"
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

# /etc/passwd


ユーザーのアカウント情報は `/etc/passwd` ファイルに保存されます。

```
1       2 3    4    5                6              7
snorlax:x:1000:1000:I Love Snorlax! :/home/snorlax:/bin/bash
```

- 1. ユーザー名
- 2. パスワード。shadow が使われている場合は x が入ります
- 3. ユーザーID
- 4. グループID
- 5. コメント
- 6. ホームディレクトリ
- 7. デフォルトシェル

