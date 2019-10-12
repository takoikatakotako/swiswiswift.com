+++
title = "UIBarButtonItem"
url = "2017-11-04"
date = "2017-11-04"
description = "Guide to emoji usage in Hugo"
tags = [
    "iOS",
]
categories = [
    "themes",
    "syntax",
]
archives = "2019/09"
aliases = ["migrate-from-jekyl"]
+++



<br>

UINavigationBarの要素追加、カスタマイズに用いられるUIBarButtonItemについてです。

UIBarButtonItemのクラス階層

NSObject
↑
UIBarItem
↑
UIBarButtonItem
AppleDeveloperリファレンスUIBarButtonItem

UIBarButtonItem例文

UINavigationBarを生成し、タイトルとボタンを付けます。

<script src="https://gist.github.com/O-Junpei/401a75d396db4548302b32e757f44e52.js"></script>


UIBarButtonItemの色の変更

UIBarButtonItemはデフォルトでは青色ですが、以下の方法で色を指定することができます。
Change color of Back button in navigation bar

//ナビゲーションボタンの色を変更する
UINavigationBar.appearance().tintColor = UIColor.black
UIBarButtonSystemItem

UIBarButtonSystemItemを用いることで、デフォルトに入っているボタンを使用することができます。https://developer.apple.com/reference/uikit/uibarbuttonsystemitem

//barButtonSystemItem:に  [.add]を設定することで[+]ボタンを設定する,上のコード参照
let leftNavBtn =  UIBarButtonItem(barButtonSystemItem:  .add, target: self, action: #selector(leftBarBtnClicked(sender:)))
Add
Done
Cancel
Edit
Save
Compose
Reply
Action
Organize
Bookmarks
Search
Refresh
Stop
Camera
Trash
Play
Pause
Rewind
Undo
Redo
PageCurl
