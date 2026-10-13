+++
title = "現在時刻の取得(kotlin)"
url = "2017-06-22"
date = "2017-06-22"
description = "現在時刻の取得(kotlin)"
tags = ["Android"]
categories = ["Android"]
archives = "2017/06"
+++

<br>

Kotlin で現在時刻の取得を行います。
アラーム機能を持ったアプリを作っています。
このあたりは Swift と異なりますね。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**getTime.kt**

```kotlin
var calendar = Calendar.getInstance()
val year = calendar.get(Calendar.YEAR)
val month = calendar.get(Calendar.MONTH)
val day = calendar.get(Calendar.DAY_OF_MONTH)
val hour = calendar.get(Calendar.HOUR_OF_DAY)
val minute = calendar.get(Calendar.MINUTE)
val second = calendar.get(Calendar.SECOND)

Log.v("time:year",year.toString())
Log.v("time:month",month.toString())
Log.v("time:day",day.toString())
Log.v("time:hour",hour.toString())
Log.v("time:minute",minute.toString())
Log.v("time:second",second.toString())
```

