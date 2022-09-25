+++
title =  "シェル変数と環境変数"
url = "2022-06-10"
date = "2022-06-10"
description = "シェル変数と環境変数"
tags = [
  "LPIC",
  "Linux"
]
categories = [
  "LPIC",
  "Linux"
]
archives = "2021/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

# シェル変数と環境変数

シェル変数と環境変数の違いについての解説です。
シェル変数は子プロセスでその値を呼び出すことはできませんが、環境変数は可能です。


## シェル変数

シェル変数は `[変数名]=[値]`　で設定できます。

```
$ MY_SHELL_VAR="This is shell variable."
```


## 環境変数

環境変数は `export [変数名]=[値]`　で設定できます。

```
$ export MY_ENV_VAR="This is environment variable."
```

## シェル変数と環境変数の違い

どちらも変数であるのでこのように `echo` で変数の値を呼び出すことができます。

```
$ echo $MY_SHELL_VAR  // This is shell variable.
$ echo $MY_ENV_VAR     // This is environment variable.
```

シェル変数と環境の違いは子プロセスでその値を使えるか使えないかです。
シェル変数は子プロセスでその値を呼び出すことはできませんが、環境変数は可能です。

たとえば以下のような `script.sh` を作成して実行します。

```
echo $MY_SHELL_VAR
echo $MY_ENV_VAR
```

```
$ sh script.sh
```

1行目のシェル変数の部分は何も表示されず、2行目の環境変数の部分のみが表示されます。
シェル変数は子プロセスに値が引き継がれないためです。

```

This is enviroment variable.
```


## シェル変数を環境変数にする

シェル変数を環境変数にすることもできます。
`export [シェル変数]` で変数を環境変数にすることができます。

```
$ export MY_SHELL_VAR
```

上記コマンド実行後に `sh script.sh` と実行するとすると、以下のように出力されます。

```
This is shell variable.
This is enviroment variable.
```
