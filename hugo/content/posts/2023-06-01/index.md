+++
title = "GolangでWindowsで動作するソフトを作る"
url = "2023-06-01"
date = "2023-06-01"
description = "GolangでWindowsで動作するソフトを作る"
tags = ["Go"]
categories = ["Go"]
archives = "2023/04"
+++

<br>

GolangでWindowsで動作するソフトを作る方法です。
"Hello World" と表示して、入力があると終了するソフトを作成し、Windows用にコンパイルしました。

```
GOOS=windows GOARCH=amd64 go build -o main.exe main.go
```

<!--more-->

**main.go**

```go
package main

import "fmt"

func main() {
	fmt.Println("Hello World")

	var value string
	fmt.Scan(&value)
}
```

