+++
title =  "ElmでIntをStringに変換する"
url = "2021-04-03"
date = "2021-04-03"
description = "ElmでIntをStringに変換する"
tags = ["Elm"]
categories = ["Elm"]
archives = "2021/04"
+++

<br>

ElmでIntをStringに変換する方法です。
`String.fromInt` で変換することができました。
Elmは慣れるまで難しいですが書いていると少しずつ楽しくなってきますね。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Main.elm**

```elm
module Main exposing (main)

import Html exposing (text)

number: Int
number = 42

main =
    text (String.fromInt(number))
```


