+++
title =  "GolangでJSONを構造体に変換する"
url = "2021-08-01"
date = "2021-08-01"
description = "GolangでJSONを構造体に変換する"
tags = ["Go"]
categories = ["Go"]
archives = "2021/08"
+++

<br>

GolangでJSONを構造体に変換する方法です。
このコードではローカルのJSONファイルを読みとり、構造体に変換しています。

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
	"os"
	"fmt"
	"log"
)

type Pokemon struct {
	Id   int    `json:"id"`
	Name string `json:"name"`
}

func main() {
	// pokemon.json を読み込む
	pokemonJsonFile, err := os.Open("pokemon.json")

	// pokemon.json の読み込みに失敗した場合
	if err != nil {
		log.Fatal(err)
	}

	// defer で pokemonJsonFile を閉じる
	defer pokemonJsonFile.Close()

	// pokemonJsonFile を読み込みパースする
	pokemonByteValue, _ := ioutil.ReadAll(pokemonJsonFile)
	var pokemon Pokemon
	json.Unmarshal(pokemonByteValue, &pokemon)

	fmt.Println(pokemon.Id, pokemon.Name)	// 143 Snorlax
}
```


**pokemon.json**

```json
{
    "id": 143,
    "name": "Snorlax"
}
```

