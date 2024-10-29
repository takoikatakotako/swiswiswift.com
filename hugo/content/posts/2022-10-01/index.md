+++
title = "apt-get（LPIC）"
url = "2022-10-01"
date = "2022-10-01"
description = "apt-get（LPIC）"
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

# apt-get

## サブコマンド

### install

### upgrade

### update

### dist-upgrade

### remove



## apt-get update と apt-get upgrade と apt-get dist-upgrade　の違い

### apt-get update

- パッケージのリストを更新する
- インストールされているパッケージの更新は行わない

### apt-get upgrade

- インストールされているパッケージを更新する. さきにupdateを実行しておく
- ただし、更新によって新規にパッケージのインストールや削除が発生するような場合は、それを行わない
- つまり、安全なアップデート

### apt-get dist-upgrade

- インストールされているパッケージを更新する.
- 更新によって新規にパッケージのインストールや削除が発生するような場合、それらも実行する

参考: [yum update と yum upgradeの違い（ついでにDebianも）](https://qiita.com/aki3061/items/4e0597505097538b6e2c)


## サンプル

### インストールされているパッケージの更新を行う

```
$ apt-get upgrade
```

### パッケージ情報の依存関係情報のキャッシュを最新の情報に更新する

```
$ apt-get update
```

### lolcatをインストールする

```
$ apt-get install lolcat
```

### lolcatをアンインストールする

```
$ apt-get remove lolcat
```


# apt-cache


## サンプル

### slが依存するパッケージの情報を表示します

```
$ apt-cache depends sl
```

