+++
title = "Jetpack Composeで画像を領域いっぱいに表示する（ContentScale.Crop）"
url = "2023-10-02-jetpack-compose-image-crop"
date = "2023-10-02"
description = "画像の縦横比を保ちながら、指定した領域を埋めるように拡大・縮小します。"
summary = "画像の縦横比を保ちながら、指定した領域を埋めるように拡大・縮小します。"
tags = ["Android", "Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2023/10"
+++

画像の縦横比を保ちながら、指定した領域を埋めるように拡大・縮小します。

<!--more-->

<a href="screenshot.png"><img src="screenshot.png" width="300" alt="画像を領域いっぱいに表示する（ContentScale.Crop）の実行画面" loading="lazy" style="max-width:100%;height:auto"></a>

## 実装のポイント

`ContentScale.Crop`では150 × 200dpの領域を埋めるため、領域からはみ出す部分が切り取られます。画像全体を見せたい場合は[Fitの例](../2023-10-01-jetpack-compose-image-fit/)を使います。

## 準備

Android StudioのCompose対応プロジェクトで、Material 3を使用します。以下のコードではパッケージ名を`com.swiswiswift.swiswikotlin`にしています。自分のプロジェクトに合わせて変更してください。テーマは`MaterialTheme`に揃えています。

各記事は独立したサンプルです。同じプロジェクトで試す場合は、前のサンプルの`MainActivity`や`ContentView`を置き換えてください。

[サンプルの画像](snorlax.png)を`app/src/main/res/drawable/snorlax.png`に置き、`res/values/strings.xml`へ次の文字列を追加します。別の画像を使用するときは、リソース名と説明も変更してください。

```xml
<resources>
    <string name="snorlax">カビゴンの画像</string>
</resources>
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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
        Image(
            modifier = Modifier
                .size(150.dp, 200.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.snorlax)
        )
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

- [Android Developers: 画像の表示と加工](https://developer.android.com/develop/ui/compose/graphics/images/customize)

## 関連記事

- [Jetpack Composeで画像全体が収まるように表示する（ContentScale.Fit）](../2023-10-01-jetpack-compose-image-fit/)
- [Jetpack Composeで画像を丸く切り取る](../2023-10-03-jetpack-compose-circle-image/)
