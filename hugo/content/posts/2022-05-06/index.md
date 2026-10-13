+++
title =  "PlaygroundでViewのプレビューを表示する"
url = "2022-05-06"
date = "2022-05-06"
description = "PlaygroundでViewのプレビューを表示する"
tags = ["Swift"]
categories = ["Swift"]
archives = "2022/05"
+++

<br>

PlaygroundでViewのプレビューを表示する方法です。
`PlaygroundPage.current.liveView` に表示したいViewを設定することでプレビューを表示できます。

![Preview](1.png)

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**index.html**

```html
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>BMI</title>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
  <h1>BMI計算機</h1>

  <p>身長(cm)</p>
  <input id="hight" type="text">

  <p>体重(kg)</p>
  <input id="weight" type="text">

  <input type="button" value="計算する" onclick="calc();"/>
</body>
</html>
```


**script.js**

```javascript
function calc() {
    const hight = document.getElementById("hight").value;
    console.log(hight);

    const weight = document.getElementById("weight").value;
    console.log(weight);

    const bmi = weight / ((hight / 100) * (hight / 100));
    console.log(bmi);

    const result = 'BMIは' + bmi + 'です';
    alert(result);
}
```

