+++
title =  "シェルスクリプトでディレクトリにあるファイル名の一覧でループする"
url = "2020-11-03"
date = "2020-11-03"
description = "シェルスクリプトでディレクトリにあるファイル名の一覧でループする"
tags = ["Bash", "Shell"]
categories = ["Bash"]
archives = "2020/11"
+++

<br>

シェルスクリプトでディレクトリにあるファイル名の一覧でループする方法です。

参考: [bashのfor文でよく使うものメモ](https://daipresents.com/2008/bash_for_memo/)

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

