+++
title =  "LambdaのコードをCLIから更新する"
url = "2022-03-02"
date = "2022-03-02"
description = "LambdaのコードをCLIから更新する"
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

LambdaのコードをCLIから更新する方法です。
list-functions コマンドで更新したい関数名を確認します。

```
aws lambda list-functions | jq
```

次にアップロードしたいファイルを zip にします。

```
zip -r lambda.zip .
```

update-function-code で zip ファイルをアップロードします。

```
aws lambda update-function-code --function-name ${FUNCTION_NAME} --zip-file fileb://lambda.zip
```
