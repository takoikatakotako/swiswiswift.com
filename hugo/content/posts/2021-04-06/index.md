+++
title =  "Elmで配列を繰り返して表示する"
url = "2021-04-06"
date = "2021-04-06"
description = "Elmで配列を繰り返して表示する"
tags = ["Elm"]
categories = ["Elm"]
archives = "2021/04"
+++

<br>

Elmで配列を繰り返して表示する方法です。
Stringの配列の内容を繰り返して表示しています。
ちなみにElmは木の名前らしいです。

![配列を繰り返して表示](1.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Main.elm**

```elm
module Main exposing (main)

import Html exposing (..)
import Html.Attributes exposing (..)


type alias Model =
    List String


initialModel : Model
initialModel =
    [ "Snorlax", "Slowpoke", "Psyduck", "Gengar" ]


liComponent : String -> Html msg
liComponent title =
    li [] [ text title ]


view : Model -> Html msg
view model =
    div []
        [ ul [] (List.map liComponent model)
        ]


main : Html msg
main =
    view initialModel
```


