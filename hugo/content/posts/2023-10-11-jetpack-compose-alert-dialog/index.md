+++
title = "Jetpack ComposeでAlertDialogを表示する"
url = "2023-10-11-jetpack-compose-alert-dialog"
date = "2023-10-11"
description = "ボタンでダイアログを開き、OKボタンで閉じる例です。"
summary = "ボタンでダイアログを開き、OKボタンで閉じる例です。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2023/10"
+++

ボタンでダイアログを開き、OKボタンで閉じる例です。

<!--more-->

<video controls loop muted playsinline preload="metadata" width="300" style="max-width:100%;height:auto" poster="poster.png">
  <source src="movie.mp4" type="video/mp4">
  <a href="movie.mp4">実行動画をダウンロード</a>
</video>

## 実装のポイント

`openDialog.value`が`true`のときだけ`AlertDialog`を表示します。OKボタンで`false`に戻すと、ダイアログが閉じます。

このサンプルでは`onDismissRequest = {}`としているので、ダイアログの外側のタップや戻る操作では閉じず、OKボタンで閉じます。外側のタップでも閉じたい場合は、このコールバックで`openDialog.value = false`にします。

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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = "Snorlax")
            },
            text = {
                Text("Snorlax is a Normal-type Pokémon introduced in Generation I.\nIt evolves from Munchlax when leveled up with high friendship.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = null
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                openDialog.value = true
            }
        ) {
            Text("Showing Dialog")
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

- [Android Developers: ダイアログ](https://developer.android.com/develop/ui/compose/components/dialog)

## 関連記事

- [Jetpack Composeでリストから画面遷移して値を渡す](../2023-10-10-jetpack-compose-navigation-argument/)
- [Jetpack ComposeでボタンごとにAlertDialogを出し分ける](../2023-10-12-jetpack-compose-multiple-dialogs/)
