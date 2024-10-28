+++
title =  "Spring Bootの起動時に文字列の配列を渡す"
url = "2022-04-01"
date = "2022-04-01"
description = "Spring Bootの起動時に文字列の配列を渡す"
tags = [
  "Spring",
  "Java"
]
categories = [
  "Spring",
  "Java"
]
archives = "2022/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

Spring Bootの起動時に文字列の配列を渡す方法です。
以下のようなオプションを付与することで `pokemons` に文字列の配列を渡すことができます。

```
java \
-jar -Dexec.mainClass=com.swiswiswift.spring.Application build/libs/spring-0.0.1-SNAPSHOT.jar \
--pokemons='"snorlax","pikachu","ditto"'
```

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}