+++
title = "more（LPIC）"
url = "2022-07-21"
date = "2022-07-21"
description = "scroll（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

# more

`more` は1画面に収まらないような長いテキストを表示するために使うコマンドです。
似たコマンドに `less` があります。
末尾まで行くと自動的にプロンプトへ戻るのが `more`、戻らないのが `less` です。


## サンプル

### file.txt　を表示する

```
$ more file.txt
```

[Space]キーを押すと次のページが表示されます。
ファイルの最終ページまで閲覧すると同時に終了します。
