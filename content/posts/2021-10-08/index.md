+++
title =  "Springを使ってお問い合わせフォームを作るその５"
url = "2021-10-08"
date = "2021-10-08"
description = "Springを使ってお問い合わせフォームを作るその５"
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

Springを使ってお問い合わせフォームを作るその５です。
前回自体でアプリケーションは大体できたので、今回からはサーバーへのアップロードの準備していきます。

作成したアプリケーションを `.jar` ファイルにします。
`.jar` ファイルにするとアプリケーションを１つのファイルにまとめることにできます。

```bash
 ./gradlew build 
```

`.jar` は `build/libs` に　`spring-0.0.1-SNAPSHOT.jar` という名前で書き出されるので確認します。

`.jar` ファイルがある場所で以下のコマンドが実行するとアプリケーションが起動します。
たとえば以下のコマンドを実行すると `localhost:8080` で起動します。

```bash
java -jar spring-0.0.1-SNAPSHOT.jar
```

プロパティを追加して実行することも可能です。
以下の例では `localhost:80` でアプリケーションを起動します。

```bash
java -jar spring-0.0.1-SNAPSHOT.jar --server.port=80
```
