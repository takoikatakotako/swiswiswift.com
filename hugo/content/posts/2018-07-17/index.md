+++
title = "最小構成のhtml、css、javascriptのテンプレート"
url = "2018-07-17"
date = "2018-07-17"
description = "最小構成のhtml、css、javascriptのテンプレート"
tags = ["HTML5"]
categories = ["HTML5"]
archives = "2018/07"
+++

<br>

html, css, javascriptのミニマムなテンプレートです。  
毎回調べているのでメモです。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**index.html**

```html
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
  <p>hello</p>
</body>
</html>
```


**script.js**

```javascript
window.onload = function() {
  console.log('hello');
}
```


**style.css**

```css
@charset "utf-8";
p {
  color: red;
}
```

