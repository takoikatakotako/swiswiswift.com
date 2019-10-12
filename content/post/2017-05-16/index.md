+++
title = "UIStatusBarを白くする"
url = "2017-05-16"
date = "2017-05-16"
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
UIStatusBarを白くする方法についてです。

UIStatusBarを白くする方法その1

UIStatusBarを白くする方法その1です。特定のViewControllerを白くする方法です。白くしたいUIViewControllerに書きます。NavigationController以下にあるStatusBarはこの方法では白くはなりませんので注意してください。

<script src="https://gist.github.com/O-Junpei/3f485ae74f1144ec0147dd81c3d677cf.js"></script>


UIStatusBarを白くする方法その2

全てのStatusBarを白くする方法です。プロジェクトのターゲットのinfoに[Status bar style]と[UIStatusBarStyleLightContent]、[View controller-based status bar appearance]と[NO]を追加します。NavigationController以下にあるStatusBarも白くなります。 わかりやすいようにViewの背景色をオレンジにしています。
