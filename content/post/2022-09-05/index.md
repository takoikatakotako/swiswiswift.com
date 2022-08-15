+++
title = "ldconfig（LPIC）"
url = "2022-09-05"
date = "2022-09-05"
description = "ldconfig（LPIC）"
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

# ldconfig

リンクの作成やライブラリのキャッシュを行うコマンドです。

`ldconfig` を実行すると `/etc/ld.so.conf` に基づいて `/etc/ld.so.cache` を再構築します。


`/etc/ld.so.cache` のファイル更新日を確認します。

```
$ ls -l /etc/ld.so.cache
```

```
-rw-r--r-- 1 root root 20231 Aug 15 15:17 /etc/ld.so.cache
```

`ldconfig` を実行します。

```
$ ldconfig
```

`/etc/ld.so.cache` のファイルが更新します。

```
$ ls -l /etc/ld.so.cache
```

```
-rw-r--r-- 1 root root 20231 Aug 15 15:17 /etc/ld.so.cache
```
