+++
title = "Jetpack Composeでリストから画面遷移して値を渡す"
url = "2023-10-10-jetpack-compose-navigation-argument"
date = "2023-10-10"
description = "リストで選んだ名前をNavigation Composeの引数として渡し、遷移先に表示します。"
summary = "リストで選んだ名前をNavigation Composeの引数として渡し、遷移先に表示します。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2023/10"
+++

リストで選んだ名前をNavigation Composeの引数として渡し、遷移先に表示します。

<!--more-->

<video controls loop muted playsinline preload="metadata" width="300" style="max-width:100%;height:auto" poster="poster.png">
  <source src="movie.mp4" type="video/mp4">
  <a href="movie.mp4">実行動画をダウンロード</a>
</video>

## 実装のポイント

ルートに`/{name}`を定義し、`NavType.StringType`で文字列の引数を受け取ります。渡す文字列には`Uri.encode`を使い、空白やスラッシュなどをルートの区切りと混同しないようにしています。

この例は保存済みサンプルに合わせたNavigation Compose 2.xの文字列ルートです。実際のアプリで複雑なオブジェクトを渡す場合は、識別子を渡して遷移先で取得する設計も検討してください。[画面間のデータの受け渡し](https://developer.android.com/guide/navigation/use-graph/pass-data)が参考になります。

## 準備

Android StudioのCompose対応プロジェクトで、Material 3を使用します。以下のコードではパッケージ名を`com.swiswiswift.swiswikotlin`にしています。自分のプロジェクトに合わせて変更してください。テーマは`MaterialTheme`に揃えています。

各記事は独立したサンプルです。同じプロジェクトで試す場合は、前のサンプルの`MainActivity`や`ContentView`を置き換えてください。

Navigation Composeを使います。元プロジェクトの依存関係は次のとおりです（2.xのサンプルです）。

```kotlin
implementation("androidx.navigation:navigation-compose:2.7.7")
```

## コード

### MainActivity.kt

[MainActivity.ktをダウンロード](MainActivity.kt)

```kotlin
package com.swiswiswift.swiswikotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.PokemonList.name
                    ) {
                        composable(Route.PokemonList.name) {
                            ContentView(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable(
                            Route.PokemonDetail.name + "/{name}",
                            arguments = listOf(navArgument("name") {
                                type = NavType.StringType
                            })
                        ) { entity ->
                            val name = entity.arguments?.getString("name") ?: "Error"
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = name, fontSize = 24.sp,
                                )
                            }
                        }
                    }
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

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme

@Composable
fun ContentView(navController: NavController, modifier: Modifier = Modifier) {
    val pokemons = arrayOf(
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

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 36.dp)
    ) {
        items(pokemons) { pokemon ->
            Column(modifier = Modifier.clickable {
                navController.navigate(Route.PokemonDetail.name + "/" + Uri.encode(pokemon))
            }) {
                Text(
                    pokemon,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp))
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MaterialTheme {
        ContentView(rememberNavController())
    }
}
```

### Route.kt

[Route.ktをダウンロード](Route.kt)

```kotlin
package com.swiswiswift.swiswikotlin

enum class Route {
    PokemonList,
    PokemonDetail,
}
```

## 参考

- [Android Developers: Navigation](https://developer.android.com/develop/ui/compose/navigation)

## 関連記事

- [Jetpack ComposeのLazyColumnでリストを表示する](../2023-10-09-jetpack-compose-lazy-column/)
- [Jetpack ComposeでAlertDialogを表示する](../2023-10-11-jetpack-compose-alert-dialog/)
