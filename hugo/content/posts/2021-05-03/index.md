+++
title =  "waitコマンドで複数の処理の完了を待つ"
url = "2021-05-03"
date = "2021-05-03"
description = "waitコマンドで複数の処理の完了を待つ"
tags = ["Bash", "Shell"]
categories = ["Shell"]
archives = "2021/05"
+++

<br>

waitコマンドで複数の処理の完了を待つ方法です。
`sh script.sh` を実行すると `sleep.sh` の完了を待ち、最後の Echo 文を実行します。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**script.sh**

```bash
#!/bin/bash

echo "Echo Command" &
sh sleep.sh
wait

echo "Finish!!"
```


**sleep.sh**

```bash
#!/bin/bash

echo "Sleep Start"
sleep 10
echo "Sleep Finish"

```


