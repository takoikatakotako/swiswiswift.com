+++
title = "Jetpack Composeでボタンを押したら文字を変える"
url = "2023-10-08-jetpack-compose-button-state"
date = "2023-10-08"
description = "rememberとmutableStateOfで文字列を保持し、ボタンから値を変更します。"
summary = "rememberとmutableStateOfで文字列を保持し、ボタンから値を変更します。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2023/10"
+++

rememberとmutableStateOfで文字列を保持し、ボタンから値を変更します。

<video controls loop muted playsinline preload="metadata" width="300" style="max-width:100%;height:auto" poster="poster.png">
  <source src="movie.mp4" type="video/mp4">
  <a href="movie.mp4">実行動画をダウンロード</a>
</video>

<!--more-->

## 実装のポイント

ボタンを押すと`text`が「Snorlax」から「Forever」に変わります。値を読む`Text`は状態の変更に合わせて再描画されます。

`remember`は再コンポーズの間に状態を保持します。画面回転などでActivityが再作成された場合にも文字列を保持したいときは、`rememberSaveable`を使います。

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
                    ContentView(innerPadding)
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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme

@Composable
fun ContentView(innerPadding: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("Snorlax") }
        Text(
            text = text,
            modifier = Modifier.padding(20.dp)
        )
        Button(
            onClick = { text = "Forever" }
        ) {
            Text(text = "Tap Me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MaterialTheme {
        ContentView()
    }
}
```

## 参考

- [Android Developers: 状態と再コンポーズ](https://developer.android.com/develop/ui/compose/state)

## 関連記事

- [Jetpack ComposeでTopAppBarにタイトルを表示する](../2023-10-07-jetpack-compose-top-app-bar/)
- [Jetpack ComposeのLazyColumnでリストを表示する](../2023-10-09-jetpack-compose-lazy-column/)
