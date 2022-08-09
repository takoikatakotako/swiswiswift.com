+++
title = "シェル変数と環境変数の違い（LPIC）"
url = "2022-10-20"
date = "2022-10-20"
description = "シェル変数と環境変数の違い（LPIC）"
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

# シェル変数と環境変数の違い

シェル変数と環境変数を設定します。

```
$ export POKEMON_ENV=Snorlax    # 環境変数を設定
$ POKEMON_SHELL=Ditto           # シェル変数を設定
$ cat << END > pokemons.sh      # pokemons.shを作成
#!/bin/sh

echo \$POKEMON_ENV
echo \$POKEMON_SHELL
END
$ chmod 777 pokemons.sh         # 権限を付与
```

シェル変数のPOKEMON_SHELLは子プロセスに引き継がれません。

```
$ bash pokemons.sh
```

```
Snorlax

```

子プロセスを作らなければ環境変数もシェル変数も表示されます。

```
$ . /Users/snorlax/Desktop/pokemons.sh 
```

```
Snorlax
Ditto
```

```
$ source pokemons.sh
```

```
Snorlax
Ditto
```
