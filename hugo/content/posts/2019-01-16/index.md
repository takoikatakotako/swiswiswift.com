+++
title = "sudo 時に PATH を引き継ぐ"
url = "2019-01-16"
date = "2019-01-16"
description = "sudo 時に PATH を引き継"
tags = ["Linux"]
categories = ["Linux"]
archives = "2019/01"
+++

<br>

which java と sudo which java でパスが違ったのでその解決

参考: [sudo「コマンドが見つかりません」PATHが初期化されているときの対処法](https://blog.thingslabo.com/archives/000395.html)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Command.md**

````markdown
```
$ sudo su -
$ visudo
```


```
# search by secure_path and comment out and describe Defaults env_keep += "PATH"
# secure_path = /sbin:/bin:/usr/sbin:/usr/bin
Defaults env_keep += "PATH"
```
````

