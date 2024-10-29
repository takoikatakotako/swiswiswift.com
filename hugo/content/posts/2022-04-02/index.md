+++
title =  "Dockerビルドに秘密情報を使う"
url = "2022-04-02"
date = "2022-04-02"
description = "Dockerビルドに秘密情報を使う"
tags = [
  "Docker"
]
categories = [
  "Docker"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

Dockerビルドに秘密情報を使う方法です。
Dockerビルド時にアクセスキーなどの秘密情報が必要な場合は `--mount=type=secret` を使用します。
`--mount=type=secret` を使用することで秘密情報をイメージの中に残さずにビルドすることができます。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

```
FROM ubuntu
RUN echo hello
RUN --mount=type=secret,id=my-secret cat /run/secrets/my-secret > secret.txt
CMD cat secret.txt
```

```
docker build --secret id=my-secret,src=secret.txt -t swiswiswift:latest .
docker run swiswiswift:latest
```
