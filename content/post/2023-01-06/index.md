+++
title = "タイムゾーン,etc（LPIC）"
url = "2023-01-06"
date = "2023-01-06"
description = "タイムゾーン,etc（LPIC）"
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

# タイムゾーン,etc


### /etc/localtime

タイムゾーンファイル、もしくはタイムゾーンファイルへのシンボリックファイルが格納されています。

### /usr/share/zoneinfo

タイムゾーンファイルが格納されている。

### locale.conf

- LC_TIME: 時刻の形式
- LC_TELEPHONE: 電話番号の形式
- LANG: 言語を定義


## サンプル

### アメリカの東海岸のタイムゾーンを設定する

シンボリックリンクで設定する方法です。

```
$ ln -sf /usr/share/zoneinfo/US/Eastern /etc/localtime
```

タイムゾーンファイルをコピーする方法です。

```
$ cp /etc/localtime /usr/share/zoneinfo/US/Eastern
```


