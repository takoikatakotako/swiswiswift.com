+++
title =  "Dockerで Alpineベースのコンテナに入る"
url = "2019-12-21"
date = "2019-12-21"
description = "Dockerで Alpineベースのコンテナに入る"
tags = [
    "Docker"
]
categories = [
    "Docker"
]
archives = "2019/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

Docker コンテナの中に入ってシェルを使いたい時ありますよね。
普通は以下のようなコマンドでコンテナの中に入るのですが、Alpine ベースの時は bash の代わりに ash を使って入ります。

```
$ docker run --rm -t -i centos:centos7 /bin/bash
```
s

```
$ docker run --rm -t -i alpine:latest /bin/ash
```

参考  
[Dockerコンテナのシェルの中に入る](https://qiita.com/__cooper/items/4740c24666299c366044)
[dockerでalpine linux ベースのcontainerに入って、shellを使いたいとき。](https://qiita.com/yutachaos/items/56dd7ea09d7e2b0d9173)


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
