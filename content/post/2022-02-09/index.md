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

次にインターネットからEC2インスタンスにアクセスできるようにセキュリティグループで80番ポートを許可します。
ブラウザにEC2インスタンスのパブリックIPを入力してアクセスするとnginxのページが表示されることを確認します。

次にローカルの index.html ファイルを scp コマンドでEC2インスタンスに転送します。

```
chmod 777 index.html
scp -i key-pair.pem index.html ec2-user@{IP_Address}:/home/ec2-user
```

nginx のページの index.html ファイルは /usr/share/nginx/html/html/index.html にあるので、先ほどアップロードした index.html で上書きします。

```
mv /home/ec2-user/index.html /usr/share/nginx/html/index.html
```

再度ブラウザにEC2インスタンスのパブリックIPを入力してアクセスするとローカルの index.html と同じ内容のものが表示されます。
