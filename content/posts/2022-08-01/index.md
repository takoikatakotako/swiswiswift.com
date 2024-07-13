+++
title = "tr（LPIC）"
url = "2022-08-01"
date = "2022-08-01"
description = "tr（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/08"
aliases = ["migrate-from-jekyl"]
+++

<br>

# cut

ファイル内の行中の特定部分のみを取り出すコマンドです。


## オプション

### -c

指定された位置の各文字だけを表示する

### -d
区切り文字を指定する


### -f
必要な項目を項目数で指定する


## サンプル

### ファイルから3-5文字目を取り出す

以下のような内容の `number.txt` があるとします。

```
123456789
```

```
$ cut -c 3-5 number.txt
```

```
$ cut -c 3-5 number.txt
```

```
345
```


### 行からから1つ目と4つ目の要素を取り出す

以下のような内容の `pokemons.txt` があるとします。

```
snorlax:143:normal:460.0kg
ditto:132:normal:4.0kg
eevee:133:normal:6.5kg
```

1つ目の要素であるポケモン名と4つ目の要素である体重を取り出します

```
$ cut -d : -f 1,4 pokemons.txt
```

```
snorlax:460.0kg
ditto:4.0kg
eevee:6.5kg
```
