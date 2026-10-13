+++
title =  "ディレクトリにあるファイル名でループする"
url = "2020-10-04"
date = "2020-10-04"
description = "ディレクトリにあるファイル名でループする"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2020/10"
+++

<br>

ディレクトリにあるファイル名でループする方法です。ディレクトリに存在する全てのファイルに処理をしたいときによく使います。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**command.sh**

```bash
for fileName in $( ls . ); do
  echo "${fileName}"
done
```

