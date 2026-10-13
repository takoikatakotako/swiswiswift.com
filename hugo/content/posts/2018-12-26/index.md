+++
title = "SSH で入ることのできるDockerイメージ(Ubuntu14.04)"
url = "2018-12-26"
date = "2018-12-26"
description = "SSH で入ることのできるDockerイメージ(Ubuntu14.04)"
tags = ["Docker"]
categories = ["Docker"]
archives = "2018/12"
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

<!--more-->

**Dockerfile**

```dockerfile
FROM ubuntu:14.04

RUN apt-get update && apt-get install -y openssh-server
RUN mkdir /var/run/sshd

RUN echo 'root:password' | chpasswd

# ユーザー作成
RUN useradd kabigon
RUN echo 'kabigon:password' |chpasswd
RUN echo "kabigon ALL=(ALL) ALL" >> /etc/sudoers
RUN mkdir /home/kabigon


ENV NOTVISIBLE "in users profile"
RUN echo "export VISIBLE=now" >> /etc/profile

EXPOSE 22
CMD ["/usr/sbin/sshd", "-D"]
```

