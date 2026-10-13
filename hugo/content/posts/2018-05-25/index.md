+++
title = "let’s encryptでさくらサーバーをhttpsにする"
url = "2018-05-25"
date = "2018-05-25"
description = "let’s encryptでさくらサーバーをhttpsにする"
tags = ["その他"]
categories = ["その他"]
archives = "2018/05"
+++

<br>

以下のサイトを参考にして証明書の設定をして以下の.htaccessをrootにおけば完成です。  
ちょっとだけ詰まりました。  

[さくらのサポート情報　【無料SSL】サーバコントロールパネルからの導入手順](https://help.sakura.ad.jp/115000136822/)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**.htaccess**

```apacheconf
# BEGIN Force SSL for SAKURA
# RewriteしてもHTTPS環境変数を有効にする
SetEnvIf REDIRECT_HTTPS (.*) HTTPS=$1
# 常時HTTPS化(HTTPSが無効な場合リダイレクト)
<IfModule mod_rewrite.c>
RewriteEngine on
RewriteCond %{ENV:HTTPS} !on
RewriteCond %{REQUEST_URI} !^/wp-cron.php$
RewriteRule .* https://%{HTTP_HOST}%{REQUEST_URI} [R=301,L]
</IfModule>
# END Force SSL for SAKURA
```

