+++
title = "ログイン時にメッセージを表示する（CentOS7）"
url = "2019-04-12"
date = "2019-04-12"
description = "ログイン時にメッセージを表示する（CentOS7）"
tags = [
    "CentOS",
]
categories = [
  "CentOS",
]
archives = "2019/04"
aliases = ["migrate-from-jekyl"]
+++

<br>

サーバーを複数管理していると間違えて異なるサーバにログインしてしまう事があります。  
ログイン時に表示したい文字は `$/etc/motd` に記述します。  
ただのテキストだと気が付きにくいので、figlet コマンドを使ってAAを作成するのがマイブームです。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

{{< gist takoikatakotako 418c1903a9f051304f3f5d8712cce81c >}}
