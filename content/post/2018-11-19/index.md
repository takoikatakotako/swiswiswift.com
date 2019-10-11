+++
title = "SSH で入ることのできるDockerイメージ(CentOS6)"
url = "2019-04-11"
date = "2019-04-11"
description = "Guide to emoji usage in Hugo"
tags = [
    "iOS",
]
categories = [
    "themes",
    "syntax",
]
archives = "2019/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

Ansibleの練習のため、SSHで入ることができるイメージが欲しくて書きました。


$ docker build -t docker_ssh:latest .
$ docker run -d -p 2222:22 docker_ssh:latest
$ ssh -p 2222 kabigon@localhost
