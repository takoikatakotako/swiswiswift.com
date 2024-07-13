+++
title =  "DockerのMySQLでdocker-entrypoint-initdb.dの完了を待つ"
url = "2021-05-04"
date = "2021-05-04"
description = "DockerのMySQLでdocker-entrypoint-initdb.dの完了を待つ"
tags = [
  "Shell",
  "Docker"
]
categories = [
  "Shell",
  "Docker"
]
archives = "2021/05"
aliases = ["migrate-from-jekyl"]
+++

<br>

DockerのMySQLでdocker-entrypoint-initdb.dの完了を待つ方法です。
`docker-compose up -d` のタイミングで実行する `sql`, `sh` などが長いと立ち上がりに時間がかかり実行が遅くなります。
CIの時とかはそれだと困るので待つ方法のメモです。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 213bc946b60f61f6536bd32fc30ca0ab >}}

