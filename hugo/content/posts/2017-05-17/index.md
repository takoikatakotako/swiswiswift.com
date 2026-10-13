+++
title = "Array(Ruby)"
url = "2017-05-17"
date = "2017-05-17"
description = "Array(Ruby)"
tags = ["Ruby"]
categories = ["Ruby"]
archives = "2017/05"
+++

<br>

Rubyの配列についてです。
最近は競技プログラミングを Ruby でやっています。
C++ への移行タイミングをいつにしようか悩んでいます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ruby_array.rb**

```ruby

#要素の作成
arr = ['apple', 'orange', 'rice','water']

#二つ目の要素にアクセス -> orange
puts arr[1]

#要素の置換 -> pineapple
arr[2] = "pineapple"
puts arr[2]

#長さの取得 -> 4
puts arr.length

#空かどうかの確認 -> false
puts arr.empty?

#ソート  -> apple orange pineapple water
puts arr.sort

#要素の追加　-> apple orange pineapple water grape
arr = arr.push("grape")
puts arr
```

