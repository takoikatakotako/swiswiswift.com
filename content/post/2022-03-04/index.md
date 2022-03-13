+++
title =  "プロファイルを使って複数のAWSアカウントを使い分ける"
url = "2022-03-04"
date = "2022-03-04"
description = "プロファイルを使って複数のAWSアカウントを使い分ける"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/03"
aliases = ["migrate-from-jekyl"]
+++

<br>

プロファイルを使って複数のAWSアカウントを使い分ける方法です。
一台のPCから複数のAWSアカウントの使い分けるためにプロファイルを使います。

サンドボックス用のプロファイルを作成し、アクセスキーとシークレットアクセスキーを入力します。

```
aws configure --profile sandbox
```

`--profile sandbox` を付与するととでアカウントを使い分けることができます。

```
aws s3api list-buckets | jq
aws s3api list-buckets --profile sandbox | jq
```
