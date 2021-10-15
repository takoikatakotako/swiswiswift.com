+++
title =  "Dockerを使ってMySQLを練習する"
url = "2021-10-03"
date = "2021-10-03"
description = "Dockerを使ってMySQLを練習する"
tags = [
  "Docker",
  "MySQL"
]
categories = [
  "Docker",
  "MySQL"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

Dockerを使ってMySQLを練習する方法です。
まず以下のような `docker-compose.yml` を作成します。

```
version: "3.7"
services:
  mysql:
    image: mysql:8.0.20
    container_name: swiswiswift-mysql
    environment:
      MYSQL_ROOT_PASSWORD: password
      MYSQL_DATABASE: swiswiswift-db
    command: mysqld --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
    ports:
      - 3306:3306
```

ターミナルなどで `docker-compose.yml` が存在するディレクトリに移動し、以下のコマンドで MySQL のコンテナを起動します。

```
docker-compose up -d
```

`mysql:8.0.20` という名前のイメージを使って `swiswiswift-mysql` という名前のコンテナ port `3306` で起動させます。
また `docker-compose.yml` に記載があるように、Root のパスワードは `password` です。

起動が完了したら以下のコマンドで MySQL にログインします。

```
docker exec -it swiswiswift-mysql mysql -u root -p  # password
```

ローカルに MySQL クライアントがインストールされている場合は以下のコマンドでも MySQL にログインできます。

```
mysql -u root -h 127.0.0.1 --port 3306 -p  # password
```

以下のコマンドで起動したコンテナを削除することができます。

```
docker-compose down
```


