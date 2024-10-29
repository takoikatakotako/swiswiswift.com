+++
title =  "Dockerを使ってPostgreSQLを立て、テーブルを作成する。"
url = "2019-11-22"
date = "2019-11-22"
description = "Dockerを使ってPostgreSQLを立て、テーブルを作成する。"
tags = [
    "Docker"
]
categories = [
    "Docker"
]
archives = "2019/11"
aliases = ["migrate-from-jekyl"]
+++

<br>
Docker を使って PostgreSQL を立てる方法です。  
開発環境を Docker をで立てて整備すると自分のローカル環境を汚さずに済むのでとても良いですよね。

[postgres-Docker Hub](https://hub.docker.com/_/postgres)

以下のコマンドで、ローカルの 5432ポートに postgres11 を立てることができ、kabigon というユーザーでログインすることができます。（パスワードはpassword）  
また pokemon というデータベースも同時に作られます。

```
$ docker run -d -p 5432:5432 -e POSTGRES_USER=kabigon -e POSTGRES_PASSWORD=password -e POSTGRES_DB=pokemon postgres:11
$ psql -h localhost -p 5432 -U kabigon -d pokemon
```

ログインができたら `\l` コマンドでデータベースの一覧を表示し、pokemon データベースが表示されていることを確認します。

また `docker-entrypoint-initdb.d` に `.sql` を置くと初期化時に実行してくれます。
初期テーブルなどを作りたい時に便利です。  
`initdb` ディレクトリ の中に `setup.sql` を作成し、ディレクトリをマウントすることで、コンテナ初期化時に `.sql` が実行されます。

```setup.sql
create table pokemon
(
  id int8,
  name varchar
);

create table pokemon_gym
(
  id int8,
  area varchar
);
```

```
$ docker run -v $PWD/initdb:/docker-entrypoint-initdb.d -d -p 5432:5432 -e POSTGRES_USER=kabigon -e POSTGRES_PASSWORD=password -e POSTGRES_DB=pokemon postgres:11
$ psql -h localhost -p 5432 -U kabigon -d pokemon
```

```
pokemon=# \d
List of relations
 Schema |    Name     | Type  |  Owner  
--------+-------------+-------+---------
 public | pokemon     | table | kabigon
 public | pokemon_gym | table | kabigon
```

`pokemon` と `pokemon_gym` テーブルが作成できていることが確認できました。

なかなかうまくいかない場合はコンテナの中に入って `docker-entrypoint-initdb.d` の中に `.sql` があるか確認すると良いかもしれません。

```
$ docker ps
$ docker exec -it 9dfa9b7caa7f bash
```

### おまけ

docker-compose で立てる場合です。

```
version: '3'

services:
  postgres:
      container_name: my-postgres
      image: postgres:11
      ports:
        - "5432:5432"
      environment:
        - POSTGRES_USER=dev
        - POSTGRES_PASSWORD=password
        - POSTGRES_DB=dev
      volumes:
        - ./postgres/initdb:/docker-entrypoint-initdb.d
```


```
.
├── docker-compose.yaml
└── postgres
    └── initdb
        └── setup.sql
```

```
$ docker-compose up -d --force-recreate
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
