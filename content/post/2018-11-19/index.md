+++
title = "SSH で入ることのできるDockerイメージ(CentOS6)"
url = "2018-11-19"
date = "2018-11-19"
description = "SSH で入ることのできるDockerイメージ(CentOS6)"
tags = [
    "Docker",
]
categories = [
    "Docker",
]
archives = "2018/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

Ansibleの練習のため、SSHで入ることができるイメージが欲しくて書きました。

```
$ docker build -t docker_ssh:latest .
$ docker run -d -p 2222:22 docker_ssh:latest
$ ssh -p 2222 kabigon@localhost
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 14d4ebc02fb6d19e6b20999226534c44 >}}
