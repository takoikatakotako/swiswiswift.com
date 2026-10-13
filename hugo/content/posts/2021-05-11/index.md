+++
title =  "JetpackComposeで画面遷移する"
url = "2021-05-11"
date = "2021-05-11"
description = "JetpackComposeで画面遷移する"
tags = ["Jetpack Compose"]
categories = ["Jetpack Compose"]
archives = "2021/05"
+++

<br>

JetpackComposeで画面遷移する方法です。
以下の記事を参考にしながら画面遷移してみました。
まだまだ分からないことだらけです。

参考: [Compose を使用して移動する](https://developer.android.com/jetpack/compose/navigation?hl=ja#setup)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**MainActivity.kt**

```kotlin
package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "profile") {
                composable("profile") {
                    Profile(navController)
                }
                composable("friendList") {
                    FriendList(navController)
                }
            }
        }
    }
}

@Composable
fun Profile(navController: NavController) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hello Profile!",
                style = TextStyle(fontSize = 22.sp, color = Color.Black)
            )
            Button(onClick = {
                navController.navigate("friendList")
            }) {
                Text(text = "Navigate friendList")
            }
        }
    }
}

@Composable
fun FriendList(navController: NavController) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hello FriendList!",
                style = TextStyle(fontSize = 22.sp, color = Color.Black)
            )
            Button(onClick = {
                navController.navigate("profile")
            }) {
                Text(text = "Navigate profile")
            }
        }
    }
}
```


**build.gradle**

```gradle
plugins {
    id 'com.android.application'
    id 'kotlin-android'
}

android {
    compileSdk 30
    buildToolsVersion "30.0.3"

    defaultConfig {
        applicationId "com.example.jetpackcomposesample"
        minSdk 21
        targetSdk 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
        useIR = true
    }
    buildFeatures {
        compose true
    }
    composeOptions {
        kotlinCompilerExtensionVersion compose_version
        kotlinCompilerVersion '1.4.32'
    }
}

dependencies {

    implementation 'androidx.core:core-ktx:1.5.0'
    implementation 'androidx.appcompat:appcompat:1.3.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling:$compose_version"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.0-alpha08'
    implementation "androidx.navigation:navigation-compose:2.4.0-alpha01"

    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
}
```


