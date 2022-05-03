+++
title =  "API GatewayのリソースIDを取得する"
url = "2022-04-08"
date = "2022-04-08"
description = "API GatewayのリソースIDを取得する"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

API GatewayのリソースIDを取得する方法です。
Terraform で API Gateway のリソースをインポートするには REST-API-ID と RESOURCE-ID が必要ですが、マネジメントコンソール上では確認することができません。
以下のコマンドで確認することができました。

```
$ aws apigateway get-resources --rest-api-id {REST-API-ID} | jq
```

[Resource: aws_api_gateway_resource](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/api_gateway_resource)
