+++
title =  "ディレクトリにあるtxtファイルでループする"
url = "2020-10-05"
date = "2020-10-05"
description = "ディレクトリにあるtxtファイルでループする"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2020/10"
+++

<br>

ディレクトリにあるtxtファイルでループする方法です。ディレクトリに存在する全ての.txtファイルに処理をしたいときによく使います。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**command.sh**

```bash
for fileName in $( ls . | grep .txt$ ); do
  echo "${fileName}"
done
```

