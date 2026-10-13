+++
title = "TextAreaに入力するたびに関数を実行する"
url = "2023-07-02"
date = "2023-07-02"
description = "TextAreaに入力するたびに関数を実行する"
tags = ["JavaScript"]
categories = ["JavaScript"]
archives = "2023/07"
+++

<br>

TextAreaに入力するたびに関数を実行する方法です。
`onkeyup` で発火させる関数を指定します。

<!--more-->

**index.html**

```html
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
  <input id="text" type="text" value="" onkeyup="update(this)" />
</body>
</html>
```


**script.js**

```javascript
function update(target) {
    const text = document.getElementById("text").value;
    console.log(text);
}
```

