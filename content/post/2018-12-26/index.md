+++
title = "SSH で入ることのできるDockerイメージ(Ubuntu14.04)"
url = "2018-12-26"
date = "2018-12-26"
description = "SSH で入ることのできるDockerイメージ(Ubuntu14.04)"
tags = [
  "iOS",
]
categories = [
    "iOS",
]
archives = "2018/12"
aliases = ["migrate-from-jekyl"]
+++

<br>


Ansibleの練習のため、SSHで入ることができるイメージが欲しくて書きました。

CentOS7はこちら
CentOS6はこちら

参考
[Docker 初心者 — ssh で接続できるサーバーを立てる](https://qiita.com/YumaInaura/items/adb20c8083fce2da86e1)

```
$ docker build -t ssh_ubuntu14:latest . --no-cache
$ docker run -d -p 2222:22 ssh_ubuntu14:latest
$ ssh-keygen -R [localhost]:2222
$ ssh -p 2222 kabigon@localhost
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 51affec5d67897a810e29872f9e28654 >}}
