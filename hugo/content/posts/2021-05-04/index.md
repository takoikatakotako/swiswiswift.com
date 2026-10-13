+++
title =  "DockerのMySQLでdocker-entrypoint-initdb.dの完了を待つ"
url = "2021-05-04"
date = "2021-05-04"
description = "DockerのMySQLでdocker-entrypoint-initdb.dの完了を待つ"
tags = ["Bash", "Docker", "Shell"]
categories = ["Docker", "Shell"]
archives = "2021/05"
+++

<br>

DockerのMySQLでdocker-entrypoint-initdb.dの完了を待つ方法です。
`docker-compose up -d` のタイミングで実行する `sql`, `sh` などが長いと立ち上がりに時間がかかり実行が遅くなります。
CIの時とかはそれだと困るので待つ方法のメモです。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**docker-compose.yml**

```yaml
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
    volumes:
      - ./sleep.sh:/docker-entrypoint-initdb.d/sleep.sh
```


**script.sh**

```bash
#!/bin/bash

docker-compose up -d
until docker exec swiswiswift-mysql mysql -h 127.0.0.1 -u root --password=password -e 'select "connection test"'; do sleep 1 ; done
echo "Script Finish!!"
```


**sleep.sh**

```bash
#!/bin/bash

echo "Sleep Start"
sleep 10
echo "Sleep Finish"

```


