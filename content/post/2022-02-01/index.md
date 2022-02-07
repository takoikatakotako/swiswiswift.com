+++
title =  "AWS CLI を使ってS3バケットを作成する"
url = "2022-02-01"
date = "2022-02-01"
description = "AWS CLI を使ってS3バケットを作成する"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/01"
aliases = ["migrate-from-jekyl"]
+++

<br>

AWS Command Line Interface（CLI）を使ってS3バケットを作成する方法です。
AWS CLIはAWSが提供するAWSサービスを管理するためのコマンドラインツールです。

参考: [AWS コマンドラインインターフェイス](https://aws.amazon.com/jp/cli/)

上記URLなどを参考にしながらAWS CLIをインストールします。
AWS CLIは1.x系と2.x系がありますが、事情がなければ2.xをインストールします。
インストールがうまくいけば以下のコマンドを実行するとバージョンが表示されます。

```
$ aws --version
# aws-cli/2.0.42 Python/3.7.4 Darwin/21.2.0 exe/x86_64
```

次にAWS CLIの初期設定を行います。`aws configure` コマンドを実行し、アクセスキーID、シークレットアクセスキー、リージョンを設定します。

S3バケットは以下のコマンドで作成することができます。
S3バケットを作成するIAM ユーザーには `S3:CreateBucket` の権限が必要です。
またバケット名はS3全体で一意である必要があります。
今回は `kabigon-sandbox-bucket` という名前でバケットを作成します。

```
$ aws s3api create-bucket --bucket kabigon-sandbox-bucket  --create-bucket-configuration LocationConstraint=ap-northeast-1
```

以下のコマンドでバケットの一覧を取得することができます。

```
$ aws s3api list-buckets
```

以下のコマンドで `kabigon-sandbox-bucket` バケットを削除します。

```
$ aws s3api delete-bucket --bucket kabigon-sandbox-bucket
```

aws s3api のドキュメントはこちらです。

[aws s3api](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/s3api/index.html)
