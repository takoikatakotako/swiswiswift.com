+++
title =  "ディレクトリにあるwavファイルをcafに変換する"
url = "2020-11-05"
date = "2020-11-05"
description = "ディレクトリにあるwavファイルをcafに変換する"
tags = ["Bash", "Shell"]
categories = ["Bash"]
archives = "2020/11"
+++

<br>

ディレクトリにあるwavファイルをcafに変換する方法です。
参考: [bashのfor文でよく使うものメモ](https://daipresents.com/2008/bash_for_memo/)

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

