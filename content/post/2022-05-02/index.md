+++
title =  "EC2にMySQLをインストールする"
url = "2022-05-02"
date = "2022-05-02"
description = "EC2にMySQLをインストールする"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/05"
aliases = ["migrate-from-jekyl"]
+++

<br>

EC2インスタンスにMySQLをインストールする方法です。


```
# ルートユーザーに切り替える。
sudo su -
```

```
# インストール可能なパッケージの一覧を更新する。
yum update
```

```
# mariadbと関連パッケージを削除
yum remove mariadb-*
```

```
# MySQLのリポジトリをyumに追加する
yum localinstall https://dev.mysql.com/get/mysql80-community-release-el7-5.noarch.rpm
```

```
# mysql-community-server, mysql-community-devel をインストールする
yum install --enablerepo=mysql80-community mysql-community-server
yum install --enablerepo=mysql80-community mysql-community-devel
```

```
# mysqlと関連パッケージがインストールされていることを確認
yum list installed | grep mysql
```

```
# MySQLのバージョンを確認
mysql --version
```

```
# /var/log/mysqld.log ファイルを作成
touch /var/log/mysqld.log
```

```
# MySQLの起動と確認
systemctl start mysqld
systemctl status mysqld.service
```

```
# 初期パスワード探す。`W.F:XG0a(c=o` が初期パスワードです
cat /var/log/mysqld.log | grep root
```

```
2022-04-20T07:18:39.168643Z 6 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: W.F:XG0a(c=o
```

```
# 初期パスワードを使って初期設定を行う
mysql_secure_installation
```

```
# ログインできることを確認
mysql -u root -p
```


### 参考
[AWS EC2 AmazonLinux2 MySQLをインストールする](https://qiita.com/miriwo/items/eb09c065ee9bb7e8fe06)

[MySQL 8.0 初期設定](https://qiita.com/ucan-lab/items/c80fb8a880679fa20162)
