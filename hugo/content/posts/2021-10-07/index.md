+++
title =  "Springを使ってお問い合わせフォームを作るその４"
url = "2021-10-07"
date = "2021-10-07"
description = "Springを使ってお問い合わせフォームを作るその４"
tags = ["Java", "Spring"]
categories = ["Java", "Spring"]
archives = "2021/10"
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

<!--more-->

**ContactForm.java**

```java
package com.swiswiswift.spring;

public class ContactForm {
    private String name;
    private String email;
    private String message;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
```


**MyController.java**

```java
package com.swiswiswift.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("form", new ContactForm());
        return "form";
    }

    @PostMapping("/form/result")
    public String getFormResult(@ModelAttribute ContactForm form, Model model) {
        model.addAttribute("form", form);
        jdbcTemplate.update("INSERT INTO contact(name,email,message) Values(?,?,?)", form.getName(), form.getEmail(), form.getMessage());
        return "result";
    }

    @GetMapping("/form/list")
    public String getFormList(Model model) {
        List<Map<String, Object>> contacts = jdbcTemplate.queryForList("select * from contact");

        model.addAttribute("contacts", contacts);
        return "list";
    }
}
```


**application.properties**

```ini
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/swiswiswift-db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
```


**build.gradle**

```gradle
plugins {
	id 'org.springframework.boot' version '2.5.6'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
}

group = 'com.swiswiswift'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-actuator'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'mysql:mysql-connector-java:8.0.20'

	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}
```


**docker-compose.yml**

```yaml
version: "3.8"
services:
  mysql:
    image: mysql:8.0.20
    container_name: swiswiswift-mysql
    environment:
      MYSQL_ROOT_PASSWORD: password
      MYSQL_DATABASE: swiswiswift-db
    command: mysqld --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
    ports:
      - 3306:3306
```


**form.html**

```html
<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Contact Form</h1>
<form action="#" th:action="@{/form/result}" th:object="${form}" method="post">
    <p>Name: <input type="text" th:field="*{name}"/></p>
    <p>Email: <input type="text" th:field="*{email}"/></p>
    <p>Message: <input type="text" th:field="*{message}"/></p>
    <p><input type="submit" value="Submit"/></p>
</form>
</body>
</html>
```


**index.html**

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


**list.html**

```html
<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Form List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>List</h1>
<div>
    <div th:each="contact : ${contacts}">
        <p th:text="'Name: ' + ${contact['name']}"></p>
        <p th:text="'Email: ' + ${contact['email']}"></p>
        <p th:text="'Message: ' + ${contact['message']}"></p>
        <hr>
    </div>
</div>
</body>
</html>
```


**result.html**

```html
<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Form Result</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Thank you!!</h1>
<p th:text="'Name: ' + ${form.name}"></p>
<p th:text="'Email: ' + ${form.email}"></p>
<p th:text="'Message: ' + ${form.message}"></p>
</body>
</html>
```

