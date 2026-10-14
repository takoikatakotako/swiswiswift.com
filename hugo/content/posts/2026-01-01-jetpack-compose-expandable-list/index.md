+++
title = "Jetpack Composeでリストの項目を開いて自動スクロールする"
url = "2026-01-01-jetpack-compose-expandable-list"
date = "2026-01-01"
description = "LazyColumnの項目を展開し、開いた項目へアニメーション付きでスクロールします。"
summary = "LazyColumnの項目を展開し、開いた項目へアニメーション付きでスクロールします。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2026/01"
+++

LazyColumnの項目を展開し、開いた項目へアニメーション付きでスクロールします。

<video controls loop muted playsinline preload="metadata" width="300" style="max-width:100%;height:auto" poster="poster.png">
  <source src="movie.mp4" type="video/mp4">
  <a href="movie.mp4">実行動画をダウンロード</a>
</video>

<!--more-->

## 実装のポイント

`openIndex`で開いている項目を保持し、`AnimatedVisibility`で本文を表示します。開くと`LaunchedEffect(openIndex)`が実行され、`animateScrollToItem`でその項目へスクロールします。この関数はコルーチンから呼び出します。[リストのスクロール制御](https://developer.android.com/develop/ui/compose/lists#controlling-scroll-position)も参照してください。

保存されていた録画では複数の項目を同時に開けますが、下のコードは仕組みが追いやすいよう、1項目ずつ開く例に整理しています。説明文と見た目も簡略化しています。元のコードで使われていた`PokemonCard`も掲載しました。

`delay(300)`は元の例に合わせた待ち時間です。展開の完了を検出する処理ではないので、アニメーションや内容を変更したら調整が必要です。最後の項目など、下側の余白が足りない場合は、スクロールしても項目が画面の一番上に届かないことがあります。

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

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    var openIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    val names = listOf("Snorlax", "Pikachu", "Ditto", "Slowpoke")
    val descriptions = listOf(
        "This is Snorlax.\n".repeat(12),
        "This is Pikachu.\n".repeat(12),
        "This is Ditto.\n".repeat(12),
        "This is Slowpoke.\n".repeat(12)
    )

    LaunchedEffect(openIndex) {
        val index = openIndex ?: return@LaunchedEffect
        delay(300)
        listState.animateScrollToItem(index)
    }

    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(names, key = { _, name -> name }) { index, name ->
            PokemonCard(
                open = openIndex == index,
                title = name,
                description = descriptions[index],
                tap = { openIndex = if (openIndex == index) null else index }
            )
        }
    }
}
```

### PokemonCard.kt

[PokemonCard.ktをダウンロード](PokemonCard.kt)

```kotlin
package com.swiswiswift.swiswikotlin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PokemonCard(
    open: Boolean,
    title: String,
    description: String,
    tap: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .clickable(onClick = tap)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = if (open) "−" else "+")
        }
        AnimatedVisibility(visible = open) {
            Column {
                Text(text = description, modifier = Modifier.padding(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .clickable(onClick = tap)
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "とじる")
                }
            }
        }
    }
}
```

## 参考

- [Android Developers: LaunchedEffectと副作用](https://developer.android.com/develop/ui/compose/side-effects)
- [Android Developers: AnimatedVisibility](https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility)

## 関連記事

- [Jetpack ComposeでボタンごとにAlertDialogを出し分ける](../2023-10-12-jetpack-compose-multiple-dialogs/)
