+++
title = "Jetpack ComposeでボタンごとにAlertDialogを出し分ける"
url = "2023-10-12-jetpack-compose-multiple-dialogs"
date = "2023-10-12"
description = "2つのボタンから異なる内容のダイアログを開きます。"
summary = "2つのボタンから異なる内容のダイアログを開きます。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2023/10"
+++

2つのボタンから異なる内容のダイアログを開きます。

<!--more-->

{{< phone-demo src="demo.gif" alt="Jetpack ComposeでボタンごとにAlertDialogを出し分けるの実行例" >}}

## 実装のポイント

ボタンごとに表示状態を持ち、対応する`AlertDialog`の内容を切り替えます。この例では、それぞれのOKボタンで該当する状態を`false`に戻しています。

ダイアログの種類が増える場合や必ず1つだけ表示したい場合は、2つのBooleanの代わりに、表示中の種類を表すenumなどを1つの状態として持つと管理しやすくなります。外側のタップで閉じない動作は[基本のダイアログ](../2023-10-11-jetpack-compose-alert-dialog/)と同じです。

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
    val openSnorlaxDialog = remember { mutableStateOf(false) }
    val openPikachuDialog = remember { mutableStateOf(false) }

    // Snorlax Dialog
    if (openSnorlaxDialog.value) {
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
                        openSnorlaxDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = null
        )
    }

    // Pikachu Dialog
    if (openPikachuDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = "Pikachu")
            },
            text = {
                Text("When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openPikachuDialog.value = false
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
                openSnorlaxDialog.value = true
            }
        ) {
            Text("Showing Snorlax Dialog")
        }

        Button(
            onClick = {
                openPikachuDialog.value = true
            }
        ) {
            Text("Showing Pikachu Dialog")
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

- [Jetpack ComposeでAlertDialogを表示する](../2023-10-11-jetpack-compose-alert-dialog/)
- [Jetpack Composeでリストの項目を開いて自動スクロールする](../2026-01-01-jetpack-compose-expandable-list/)
