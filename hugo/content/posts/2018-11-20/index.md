+++
title = "BottomNavigationViewで切り替え時に色を変える"
url = "2018-11-20"
date = "2018-11-20"
description = "BottomNavigationViewで切り替え時に色を変える"
tags = ["Android"]
categories = ["Android"]
archives = "2018/11"
+++

<br>

res/color　ディレクトリ以下に　bottom_navigation_color.xml ファイルを作成し、そこにstateごとの色を書くことで実現できます。

![alt](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <FrameLayout
                android:id="@+id/fragment_container"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_marginBottom="56dp"
                android:text="@string/title_home"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

        <android.support.design.widget.BottomNavigationView
                android:id="@+id/navigation"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:background="@color/colorBottomNavigation"
                app:itemIconTint="@color/bottom_navigation_color"
                app:itemTextColor="@color/bottom_navigation_color"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:menu="@menu/navigation" />

    </android.support.constraint.ConstraintLayout>
```


**bottom_navigation_color.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_checked="true" android:color="@color/colorMain" />
    <item android:state_checked="false" android:color="@color/colorLightGray"/>
</selector>
```

