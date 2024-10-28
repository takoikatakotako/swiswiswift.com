+++
title = "セッションマネージャーを使ってEC2インスタンス(AmazonLinux2023)にログインする"
url = "2023-07-04"
date = "2023-07-04"
description = "セッションマネージャーを使ってEC2インスタンス(AmazonLinux2023)にログインする"
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

セッションマネージャーを使ってEC2インスタンスにログインする方法です。

## EC2インスタンスのセットアップ

マネジメントコンソールからEC2にアクセスし、インスタンスの起動を選択します。
アプリケーションのイメージに AmazonLinux2023を選択します。
キーペアは作成せず、ネットワークはデフォルトVPCを指定します。
セキュリティグループには何も許可する必要がありません、SSH用の22番ポートにも許可を加える必要はありません。


## セッションマネージャー用のロールを作成

IAM > ロールを選択し、ロールを作成します。
ユースケースに EC2 を選択します。

{{< figure src="1.png" width="600" >}}

許可ポリシーに `AmazonSSMManagedInstanceCore` を追加します。

{{< figure src="2.png" width="600" >}}


## EC2インスタンスにロールの紐付け

作成したEC2インスタンスに作成したロールをアタッチします。

{{< figure src="3.png" width="600" >}}


## セッションマネージャーを使用してEC2インスタンスに接続

インスタンスの接続画面からセッションマネージャーを選択し、EC2インスタンスにログインできることを確認します。

{{< figure src="4.png" width="600" >}}


## AWS CLIからEC2インスタンスに接続する

AWS CLIからECインスタンスに接続します。
以下のコマンドでAWS CLIからセッションマネージャーを使用してEC2インスタンスに接続します。
プラグインがインストールされていない場合は別途インストールが必要になります。

[Troubleshooting Session Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/session-manager-troubleshooting.html#plugin-not-found)


[署名されたインストーラーを使用して Session Manager プラグインを macOS にインストールする](https://docs.aws.amazon.com/ja_jp/systems-manager/latest/userguide/session-manager-working-with-install-plugin.html#install-plugin-macos-signed)


```
aws ssm start-session --target {EC2インスタンスID} --region ap-northeast-1
```
