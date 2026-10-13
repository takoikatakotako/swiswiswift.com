+++
title =  "Golangで配列のJSONを構造体の配列に変換する"
url = "2021-09-01"
date = "2021-09-01"
description = "Golangで配列のJSONを構造体の配列に変換する"
tags = ["Go"]
categories = ["Go"]
archives = "2021/09"
+++

<br>

Golangで構造体をJSONファイルとして出力する方法です。
このコードではローカルのJSONファイルを読みとり、構造体の配列に変換しています。

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
	// pokemons.json を読み込む
	pokemonsJsonFile, err := os.Open("pokemons.json")

	// pokemons.json の読み込みに失敗した場合
	if err != nil {
		log.Fatal(err)
	}

	// defer で pokemonsJsonFile を閉じる
	defer pokemonsJsonFile.Close()

	// pokemonsJsonFile を読み込みパースする
	pokemonsByteValue, _ := ioutil.ReadAll(pokemonsJsonFile)
	var pokemons []Pokemon
	json.Unmarshal(pokemonsByteValue, &pokemons)

	fmt.Println(pokemons)	// [{132 Ditto} {133 Eevee} {143 Snorlax}]
}
```


**pokemons.json**

```json
[
  {
    "id":132,
    "name":"Ditto"
  },
  {
    "id":133,
    "name":"Eevee"
  },
  {
    "id":143,
    "name":"Snorlax"
  }
]
```

