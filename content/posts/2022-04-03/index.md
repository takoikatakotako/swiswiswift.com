+++
title =  "cut コマンドで文字をカットする"
url = "2022-04-03"
date = "2022-04-03"
description = "cut コマンドで文字をカットする"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

cutコマンドを使うことで文字列を切り取ることができます。
2文字目から4文字目をカットしています。

```
echo "123456" | cut -b 2-4  # 234
```

また区切り文字を指定して切り取ることもできます。
/区切りで配列を作り、二要素目を取り出すイメージです。
0始まりではないので注意が必要です。

```
echo "slowpoke/snorlax/eevee/meowth/ditto" | cut -d "/" -f 2    # snorlax
```
