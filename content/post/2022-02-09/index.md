+++
title =  "EC2インスタンスにnginxをインストールしてブラウザからアクセスする"
url = "2022-02-09"
date = "2022-02-09"
description = "EC2インスタンスにnginxをインストールしてブラウザからアクセスする"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/02"
aliases = ["migrate-from-jekyl"]
+++

<br>

EC2インスタンスを立ててnginxをインストールしてブラウザからアクセスする方法です。
まずSSH用のキーペアに権限を付与します。

```
chmod 400 key-pair.pem
```

キーペアを使ってSSHログインします。

```
ssh -i key-pair.pem ec2-user@{IP_Address}
```

nginxをインストールします。

```
yum search nginx
sudo amazon-linux-extras install nginx1
nginx -v
```

nginxを起動します。起動したことを確認します。

```
sudo systemctl start nginx
sudo systemctl status nginx
```

curlコマンドでなんとかする。

```
curl localhost
```


セキュリティグループで80番ポートを許可する。
ブラウザIPアドレスを入力し、nginxを表示できることを確認する。


index.html ファイルを SCPで転送する。

cd  /usr/share/nginx/html

chmod 777 index.html
scp -i ./2022-02-20-delete-me.pem index.html ec2-user@18.183.251.213:/home/ec2-user
ssh -i 2022-02-20-delete-me.pem ec2-user@18.183.251.213
mv /home/ec2-user/index.html /usr/share/nginx/html/index.html


PythonでWebサイトのHTMLファイルを取得して保存する方法です。
urllibでGETアクセスし、レスポンスを文字列として保存しています。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

{{< gist takoikatakotako 1a54d6808fe1d35c2e020f9e5f8ef55a >}}

