+++
title = "Jetpack ComposeのLazyColumnでリストを表示する"
url = "2023-10-09-jetpack-compose-lazy-column"
date = "2023-10-09"
description = "LazyColumnに名前の一覧を渡し、縦にスクロールできるリストを表示します。"
summary = "LazyColumnに名前の一覧を渡し、縦にスクロールできるリストを表示します。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2023/10"
+++

LazyColumnに名前の一覧を渡し、縦にスクロールできるリストを表示します。

<!--more-->

{{< phone-demo src="demo.gif" alt="Jetpack ComposeのLazyColumnでリストを表示するの実行例" >}}

## 実装のポイント

`items(pokemons)`で名前ごとの行を作り、各行の下に`HorizontalDivider`を置いています。キーには重複しない名前を使用します。

保存されていた`ContentView.kt`は空だったため、録画と[値を渡す画面遷移の素材](../2023-10-10-jetpack-compose-navigation-argument/)をもとに、タップ操作のないリストとしてコードを補っています。

## 準備

Android StudioのCompose対応プロジェクトで、Material 3を使用します。以下のコードではパッケージ名を`com.swiswiswift.swiswikotlin`にしています。自分のプロジェクトに合わせて変更してください。テーマは`MaterialTheme`に揃えています。

各記事は独立したサンプルです。同じプロジェクトで試す場合は、前のサンプルの`MainActivity`や`ContentView`を置き換えてください。

## コード

### MainActivity.kt

[MainActivity.ktをダウンロード](MainActivity.kt)

```kotlin
package com.swiswiswift.swiswikotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContentView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
```

### ContentView.kt

[ContentView.ktをダウンロード](ContentView.kt)

```kotlin
package com.swiswiswift.swiswikotlin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    val pokemons = listOf(
        "Bulbasaur",
        "Ivysaur",
        "Venusaur",
        "Charmander",
        "Charmeleon",
        "Charizard",
        "Squirtle",
        "Wartortle",
        "Blastoise",
        "Caterpie",
        "Metapod",
        "Butterfree",
        "Weedle",
        "Kakuna",
        "Beedrill"
    )

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(pokemons, key = { it }) { pokemon ->
            Text(
                text = pokemon,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            HorizontalDivider()
        }
    }
}
```

## 参考

- [Android Developers: LazyColumnとリスト](https://developer.android.com/develop/ui/compose/lists)

## 関連記事

- [Jetpack Composeでボタンを押したら文字を変える](../2023-10-08-jetpack-compose-button-state/)
- [Jetpack Composeでリストから画面遷移して値を渡す](../2023-10-10-jetpack-compose-navigation-argument/)
