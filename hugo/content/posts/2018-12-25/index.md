+++
title = "SSH で入ることのできるDockerイメージ(CentOS7)"
url = "2018-12-25"
date = "2018-12-25"
description = "SSH で入ることのできるDockerイメージ(CentOS7)"
tags = ["Docker"]
categories = ["Docker"]
archives = "2018/12"
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

<!--more-->

**Dockerfile**

```dockerfile
FROM centos:centos7

# 後々必要そうなパッケージをまとめてインストール
RUN yum -y update; yum clean all
RUN yum -y install openssh-server passwd; yum clean all

# ユーザーを追加
RUN useradd kabigon
RUN echo 'kabigon:password' |chpasswd
RUN echo "kabigon ALL=(ALL) ALL" >> /etc/sudoers

# rootのパスワードを設定
RUN echo 'root:password' |chpasswd

# 22番ポートを外に開ける
EXPOSE 22

# ホストキーを作成 使わなくても作成する必要がある
RUN ssh-keygen -t rsa -f /etc/ssh/ssh_host_rsa_key -N ''
ENTRYPOINT ["/usr/sbin/sshd", "-D"]
```

