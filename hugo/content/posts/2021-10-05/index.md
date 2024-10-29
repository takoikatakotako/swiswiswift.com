+++
title =  "Springを使ってお問い合わせフォームを作るその２"
url = "2021-10-05"
date = "2021-10-05"
description = "Springを使ってお問い合わせフォームを作るその２"
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

Springを使ってお問い合わせフォームを作るその２です。
今回はDBまわりを作っていきます。

まずDockerを使ってMySQLサーバーを立ち上げます。
以下のような `docker-compose.yml` を作成します。

```yml
version: "3.8"
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

```bash
docker-compose up -d
```

`mysql:8.0.20` という名前のイメージを使って `swiswiswift-mysql` という名前のコンテナ port `3306` で起動させます。
また `docker-compose.yml` に記載があるように、Root のパスワードは `password` です。

起動が完了したら以下のコマンドで MySQL にログインします。

```bash
mysql -u root -h 127.0.0.1 --port 3306 -p  # password
```

`swiswiswift-db` を選択します。

```bash
use swiswiswift-db
```

お問い合わせフォームで入力する値は名前、Email、お問い合わせ内容なのでそれらを保存する `contact` テーブルを作成します。

```sql
create table contact(
    name varchar(255) not null,
    email varchar(255) not null,
    message varchar(1023) not null
);
```

テーブルを作成したらお問い合わせ内容が入ることを確認します。

```
insert contact (name, email, message) values ('Snorlax', 'snorlax@pokemon.com', 'Snorlax is the best cute pokemon.');
insert contact (name, email, message) values ('Eveee', 'eveee@pokemon.com', 'Cute pokemon.');
```

お問い合わせ内容を表示します。

```
select * from contact;
```

```
+---------+---------------------+------------------------------+
| name    | email               | message                      |
+---------+---------------------+------------------------------+
| Snorlax | snorlax@pokemon.com | Snorlax is the best pokemon. |
| Eveee   | eveee@pokemon.com   | Cute pokemon.                |
+---------+---------------------+------------------------------+
```
