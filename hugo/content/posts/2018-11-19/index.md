+++
title = "SSH で入ることのできるDockerイメージ(CentOS6)"
url = "2018-11-19"
date = "2018-11-19"
description = "SSH で入ることのできるDockerイメージ(CentOS6)"
tags = ["Docker"]
categories = ["Docker"]
archives = "2018/11"
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

<!--more-->

**Dockerfile**

```dockerfile
FROM centos:centos6

# 後々必要そうなパッケージをまとめてインストール
RUN yum -y update
RUN yum -y install git vim && \
    yum clean all
RUN yum -y install automake bison bzip2 gcc gcc-c++ gdbm-devel git libffi-devel libtool libxml2-devel libxslt-devel make openssh openssh-clients openssh-server openssl openssl-devel passwd patch readline readline-devel rsync sqlite-devel sudo tar tcl tcl-devel tk tk-devel vim wget which zlib zlib-devel && \
    yum clean all

# ユーザー作成
RUN useradd kabigon
RUN echo 'kabigon:password' |chpasswd
RUN echo "kabigon    ALL=(ALL)       ALL" >> /etc/sudoers

# SSHD の初期化
RUN /etc/init.d/sshd start
RUN /etc/init.d/sshd stop

# 22番ポートを外に開ける
EXPOSE 22

# SSHD をデーモンとして起動する
CMD ["/usr/sbin/sshd", "-D"]
```

