+++
title = "systemd（LPIC）"
url = "2022-11-24"
date = "2022-11-24"
description = "systemd（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

# systemd


## サンプル

### nginxサービスを起動する

```
$ systemctl start nginx.service
```

### nginxサービスを停止する

```
$ systemctl stop nginx.service
```

### nginxサービスを再起動する

```
$ systemctl restart nginx.service
```

### nginxサービスのステータスを表示

```
$ systemctl status nginx.service
```

### nginxサービスが起動しているか表示

```
$ systemctl is-active nginx.service
```

### nginxサービスを自動起動の設定をする

```
$ systemctl enable nginx.service
```

### nginxサービスを自動起動の設定を解除する

```
$ systemctl disable nginx.service
```


## ランレベル

### Red Hat Enterprise Liux, CentOS. Fedoraでのランレベル

- 0: 停止
- 1: シングルユーザーモード
- 2: マルチユーザーモード（テキストログイン、NFSサーバーは停止）
- 3: マルチユーザーモード（テキストログイン）
- 4: 未使用
- 5: マルチユーザーモード（グラフィカルログイン）
- 6: 再起動
- s: シングルユーザーモード

### Ubuntu, Debian GNU/Linux でのランレベル

- 0: 停止
- 1: シングルユーザーモード
- 2: マルチユーザーモード
- 3: マルチユーザーモード
- 4: マルチユーザーモード
- 5: マルチユーザーモード
- 6: 再起動
- s: シングルユーザーモード


## その他

`/lib/systemd/system` ディレクトリ以下にはsystemd のデフォルトのUnit定義さいるが格納されています。

