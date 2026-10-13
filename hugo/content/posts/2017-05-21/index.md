+++
title = "Androidアプリのステータスバーの変更"
url = "2017-05-21"
date = "2017-05-21"
description = "Androidアプリのステータスバーの変更"
tags = ["Android"]
categories = ["Android"]
archives = "2017/05"
+++

<br>

Androidアプリのステータスバーの変更方法です。
色を直指定するのは良くないです、Color.xml に書きましょう。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**statusBarChange.xml**

```xml
<!-- ステータスバーの色を変更する-->
<item name="android:statusBarColor">@android:color/white</item>
```

