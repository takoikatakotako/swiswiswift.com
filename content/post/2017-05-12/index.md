+++
title = "UITextField"
url = "2017-05-12"
date = "2017-05-12"
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

UITextFieldは文字の入力に使われます。

UITextFieldのクラス階層

NSObject
↑
UIResponder
↑
UIView
↑
UIControl
↑
UITextField
AppleDeveloperリファレンスUITextField

UITextField例文

UITextField、生成し、ボタンが押されるとUITextFieldから文字列を取り出してラベルにコピーします。

<script src="https://gist.github.com/O-Junpei/d3e668838373df7c0698a18efd512edf.js"></script>
