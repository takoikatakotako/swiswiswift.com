+++
title =  "Lambdaトリガー（Lambda Permission）のStatement IDを確認する"
url = "2022-04-09"
date = "2022-04-09"
description = "Lambdaトリガー（Lambda Permission）のStatement IDを確認する"
tags = [
  "AWS",
  "Terraform"
]
categories = [
  "AWS",
  "Terraform"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

Lambdaトリガー（Lambda Permission）のStatement IDを確認する方法です。
Terraform で API Gateway のLambdaトリガーをインポートするには関数名とLambdaトリガーのStatement IDが必要です。
以下のコマンドで確認することができました。

```
$ aws lambda get-policy --function-name {YOUR-FUNCTION-NAME} | jq
```

[Resource: aws_lambda_permission](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/lambda_permission)
