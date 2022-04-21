+++
title =  ""
url = "2022-04-05"
date = "2022-04-05"
description = "findコマンドでディレクトリを探す"
tags = [
  "Linux",
  "find"
]
categories = [
  "Linux",
  "find"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

findコマンドでディレクトリを探す方法です。
findコマンドで2階層以内のsnorlaxディレクトリを検索します。

```
.
├── slowpoke
│   └── snorlax
└── snorlax
    └── snorlax
        └── snorlax
            └── snorlax
                └── snorlax
```

```
find . -type d -maxdepth 2 -name "snorlax"
```

```
./snorlax
./snorlax/snorlax
./slowpoke/snorlax
```

