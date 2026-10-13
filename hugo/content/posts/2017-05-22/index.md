+++
title = "Androidアプリのアクションバーの影を消す"
url = "2017-05-22"
date = "2017-05-22"
description = "Androidアプリのアクションバーの影を消す"
tags = ["Android"]
categories = ["Android"]
archives = "2017/05"
+++

<br>

Androidアプリのアクションバーの影を消します。
アプリはどんどん新しいことが増えていくので覚えるのが大変です。


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**hideActionbarShadow.xml**

```xml
<!--アクションバーの影を消す-->
<android.support.design.widget.AppBarLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:elevation="0dp">
```

