+++
title =  "PHP で本当に簡単なモックサーバーを作る"
url = "2019-11-07"
date = "2019-11-07"
description = "PHP で本当に簡単なモックサーバーを作る"
tags = ["PHP"]
categories = ["PHP"]
archives = "2019/11"
+++

<br>

ローカルにモックサーバーが必要だったので簡単なものをPHPで作ってみました。  
`signup.php` でユーザー登録を行い、`list.php` でユーザーの一覧を表示し、`deleate.php` でユーザーを全て削除します。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< highlight html >}}
# サーバー起動
$ php -S localhost:8000
{{< /highlight >}}

{{< highlight html >}}
# ユーザー登録
$ curl http://localhost:8000/signup.php -X POST -H "Content-Type: application/json" -d '{"name":"onojun", "age":24}'
{{< /highlight >}}

{{< highlight html >}}
# ユーザー一覧
$ curl http://localhost:8000/list.php
{{< /highlight >}}

{{< highlight html >}}
# 全てのユーザーを削除
$ curl http://localhost:8000/deleate.php
{{< /highlight >}}

<!--more-->

**db.json**

```json
[]
```


**deleate.php**

```php
<?php
  // curl http://localhost:8000/deleate.php
  header("Access-Control-Allow-Origin: *");

  // parse request
  file_put_contents("db.json" , json_encode(array()));
  $response = array(
    "is_success" => true
  );
  echo json_encode($response);
```


**list.php**

```php
<?php
// curl http://localhost:8000/list.php
  header("Access-Control-Allow-Origin: *");

  // connect to db()
  $db_url = "db.json";
  $all_users = file_get_contents($db_url);
  $all_users = (array)json_decode($all_users, true);
  echo json_encode($all_users);
```


**signup.php**

```php
<?php
  // curl http://localhost:8000/signup.php -X POST -H "Content-Type: application/json" -d '{"name":"onojun", "age":24}'
  header("Access-Control-Allow-Origin: *");

  // parse request
  $json_string = file_get_contents('php://input');
  $obj = json_decode($json_string);
  $name = $obj->name;
  $age = $obj->age;

  if ($name == null) {
    $response = array(
      "is_success" => false,
      "reason" => "name is null"
    );
    echo json_encode($response);
    return;
  } elseif ($age == null) {
    $response = array(
      "is_success" => false,
      "reason" => "age is null"
    );
    echo json_encode($response);
    return;
  }

  // connect to db()
  $db_url = "db.json";
  $all_users = file_get_contents($db_url);
  $all_users = (array)json_decode($all_users, true);

  // add user
  $id = count($all_users);
  $user = array(
    "id" => $id,
    "name" => $name,
    "age" => $age
  );
  array_push($all_users, $user);
  file_put_contents("db.json" , json_encode($all_users));

  $response = array(
    "is_success" => true
  );
  echo json_encode($response);
```

