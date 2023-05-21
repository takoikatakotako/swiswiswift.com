+++
title = "GolangでWindowsで動作するソフトを作る"
url = "2023-06-01"
date = "2023-06-01"
description = "GolangでWindowsで動作するソフトを作る"
tags = [
  "Golang"
]
categories = [
  "Golang"
]
archives = "2023/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

GolangでWindowsで動作するソフトを作る方法です。
"Hello World" と表示して、入力があると終了するソフトを作成し、Windows用にコンパイルしました。

```
GOOS=windows GOARCH=amd64 go build -o main.exe main.go
```

{{< gist takoikatakotako f1b0b5c27a0916600370195028aad45e >}}
