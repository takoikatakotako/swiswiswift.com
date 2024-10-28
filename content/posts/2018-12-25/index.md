+++
title = "SSH で入ることのできるDockerイメージ(CentOS7)"
url = "2018-12-25"
date = "2018-12-25"
description = "SSH で入ることのできるDockerイメージ(CentOS7)"
tags = [
  "Docker",
]
categories = [
    "Docker",
]
archives = "2018/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

Ansibleの練習のため、SSHで入ることができるイメージが欲しくて書きました。

```
docker build -t ssh_centos7:latest . --no-cache
docker run -d -p 2222:22 ssh_centos7:latest
ssh-keygen -R [localhost]:2222
ssh -p 2222 kabigon@localhost
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako d3f4096b9301a56e05e7ab8239439fe6 >}}
