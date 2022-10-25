+++
title =  "AWSでEC2をプライベートサブネットに設置する"
url = "2022-06-12"
date = "2022-06-12"
description = "AWSでEC2をプライベートサブネットに設置する"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2021/06"
aliases = ["migrate-from-jekyl"]
+++

<br>

AWSでEC2をプライベートサブネットに設置する方法です。

Private-Subnetを作成します。

![Image](1.png)


Private-SubnetにEC2インスタンスを作成します。
パブリックIPが無いため、外部からSSHすることはできません。

Public-Subnetに踏み台インスタンスをインスタンスを作成します。

```
$ ssh -i key-pair.pem ec2-user@{PUBLIC_EC2_IP}
```

scpでPublic-Instanceにキーペア（秘密鍵）を送信します。

```
$ scp -i key-pair.pem key-pair.pem ec2-user@{PUBLIC_EC2_IP}:/home/ec2-user/key-pair.pem
```

秘密鍵の権限を設定します。

```
$ chmod /home/ec2-user/key-pair.pem
```

Private Instance にアクセスします。

```
$ ssh -i key-pair.pem ec2-user@{PRIVATE_INSTANCE_LOCAL_IP}
```

Private Instance の中からではインターネットにアクセスできないことを確認します。

```
$ curl http://abehiroshi.la.coocan.jp/    # アクセスできない
```

NATゲートウェイを作成します。

![Image](2.png)

Routeテーブルの作成し、送信元の設定とサブネットの関連付けを行います。

![Image](3.png)

![Image](4.png)

![Image](5.png)


これでPublic-Instanceからインターネットにアクセスすることができます。

```
$ curl http://abehiroshi.la.coocan.jp/
```