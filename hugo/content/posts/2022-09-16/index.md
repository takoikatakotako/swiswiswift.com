+++
title = "シェルスクリプト（LPIC）"
url = "2022-09-16"
date = "2022-09-16"
description = "シェルスクリプト（LPIC）"
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

# シェルスクリプト

シェル上で実行できるプログラミング言語です。


## 変数

### $$

シェルのPID

### $?

最後に時効したコマンドの終了値

### $#

引数の数


## 関数

```
$ function snorlaxFunc() { echo 'Snorlax' }
$ snorlaxFunc()
```

```
Snorlax
```



## サンプル

### snorlax.txtがあるか調べる

```
if [ -f ./snorlax.txt ]; then
    echo 'snorlax.txt is exists!'
fi
```

```
if test -f ./snorlax.txt; then
    echo 'snorlax.txt is exists!'
fi
```


### 引数の数を表示する

```
#!/bin/sh

echo $#
```

```
./script.sh snorlax ditto
```

```
2
```


### 30秒ごとにSnorlaxと出力する

```
while true
do
  echo Snorlax
  sleep 30
done
```
