+++
title =  "Golangで構造体をJSONファイルとして出力する"
url = "2021-09-02"
date = "2021-09-02"
description = "Golangで構造体をJSONファイルとして出力する"
tags = ["Go"]
categories = ["Go"]
archives = "2021/09"
+++


<br>

Golangで構造体をJSONファイルとして出力する。
このコードでは構造体PokemonをJSONとして書き出しています。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**main.go**

```go
package main

import (
	"encoding/json"
	"io/ioutil"
)

type Pokemon struct {
	Id   int    `json:"id"`
	Name string `json:"name"`
}

func main() {
	pokemon := Pokemon{143, "Snorlax"}
	file, _ := json.MarshalIndent(pokemon, "", " ")
	_ = ioutil.WriteFile("pokemon.json", file, 0644)
}
```

