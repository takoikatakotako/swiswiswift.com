+++
title =  "ディレクトリにあるwavファイルをcafに変換する"
url = "2020-10-06"
date = "2020-10-06"
description = "ディレクトリにあるwavファイルをcafに変換する"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2020/10"
+++

<br>

ディレクトリにあるwavファイルをcafに変換する方法です。ディレクトリに存在する全ての.wavファイルをcafファイルに変換したいときによく使います。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**command.sh**

```bash
for fileName in $( ls . | grep .wav$ ); do
  afconvert -f caff -d ima4 ${fileName}
done
```

