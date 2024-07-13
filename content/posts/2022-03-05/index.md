+++
title =  "DynamoDBのスキャン時に「Attribute name is a reserved keyword; reserved keyword: type」が出る"
url = "2022-03-05"
date = "2022-03-05"
description = "DynamoDBのスキャン時に「Attribute name is a reserved keyword; reserved keyword: type」が出る"
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

DynamoDBのスキャン時に「Attribute name is a reserved keyword; reserved keyword: type」が出る時の対処法です。
カラム名に[DynamoDBの予約語](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html)が使われていると出ました。

具体的にはテーブルに以下のようなアイテムを追加し、type でスキャンするとエラーが起きました。

```
aws dynamodb put-item \
--table-name pokemon-table \
--item '{ "number": { "N": "143" }, "name": { "S": "Snorlax" }, "type": { "S": "Normal" } }'
```

```
aws dynamodb scan \
--table-name pokemon-table \
--filter-expression 'type = :tp' \
--expression-attribute-values '{ ":tp": { "S": "Normal" } }'
```

```
An error occurred (ValidationException) when calling the Scan operation: Invalid FilterExpression: Attribute name is a reserved keyword; reserved keyword: type
```

`expression-attribute-names` を使い、type に別名を付けることで回避できました。

```
aws dynamodb scan \
--table-name pokemon-table \
--filter-expression '#tp = :tp' \
--expression-attribute-values '{ ":tp": { "S": "Normal" } }' \
--expression-attribute-names '{"#tp":"type"}'
```

そもそも予約語をカラム名にしない方が良いのかもしれません。
