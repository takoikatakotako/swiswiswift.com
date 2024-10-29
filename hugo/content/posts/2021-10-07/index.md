+++
title =  "Springを使ってお問い合わせフォームを作るその４"
url = "2021-10-07"
date = "2021-10-07"
description = "Springを使ってお問い合わせフォームを作るその４"
tags = [
  "Java",
  "Spring"
]
categories = [
  "Java",
  "Spring"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

Springを使ってお問い合わせフォームを作るその４です。
今回はフォームから DB に追加できるようにします。

`getFormResult` にインサートするメソッドを追加します。

```java
    @PostMapping("/form/result")
    public String getFormResult(@ModelAttribute ContactForm form, Model model) {
        model.addAttribute("form", form);
        jdbcTemplate.update("INSERT INTO contact(name,email,message) Values(?,?,?)", form.getName(), form.getEmail(), form.getMessage());
        return "result";
    }
```

フォームから送られた情報が DB に保存されます。

最後に `index.html` を作成して完成です。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<body>
<ul>
    <a href="/form"><li>Form</li></a>
    <a href="/form/list"><li>List</li></a>
</ul>
</body>
</html>
```

```java
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
```

最終的なファイルはこちらです。

{{< gist takoikatakotako 11e97af3b5410e979b35e5ce825f7755 >}}
