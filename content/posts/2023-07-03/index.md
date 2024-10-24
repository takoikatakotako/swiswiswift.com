+++
title = "プロキシ環境下でAWSCLIを使う"
url = "2023-07-03"
date = "2023-07-03"
description = "プロキシ環境下でAWSCLIを使う"
tags = [
  "JavaScript"
]
categories = [
  "JavaScript"
]
archives = "2023/07"
aliases = ["migrate-from-jekyl"]
+++

<br>

プロキシ環境下でAWSCLIを使う方法です。
環境変数 `http_proxy`, `https_proxy` にプロキシのURLを設定することで解決しました。

```
# Mac
export http_proxy={HTTPプロキシのURL}:{ポート番号}
export https_proxy={HTTPSプロキシのURL}:{ポート番号}

# Windows
set http_proxy={HTTPプロキシのURL}:{ポート番号}
set https_proxy={HTTPSプロキシのURL}:{ポート番号}
```
