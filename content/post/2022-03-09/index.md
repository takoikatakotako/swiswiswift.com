+++
title =  "API Gatewayに独自ドメインを設定する"
url = "2022-03-09"
date = "2022-03-09"
description = "API Gatewayに独自ドメインを設定する"
tags = [
  "AWS"
]
categories = [
  "AWS"
]
archives = "2022/03"
aliases = ["migrate-from-jekyl"]
+++

<br>

API Gatewayに独自ドメインを設定する方法です。

API Gateway用のLambda関数を作成します。

![Create Function](1.png)

API GatewayでRestAPIを作ります。

![Create RestAPI](2.png)


メソッドを作成します。先ほど作成した Lambda関数を設定します。

![Create RestAPI](3.png)

![Create RestAPI](4.png)


アクションから「APIのデプロイ」を選択します。

![API Deploy](5.png)


ステージが既に作られていない場合はステージを作成します。

![Create Stage](6.png)


作成されたステージ + メソッド名をブラウザに入力し、`"Hello from Lambda!"` と表示されることを確認します。
今回の場合は `https://yyd1qtujv0.execute-api.ap-northeast-1.amazonaws.com/production` となります。


![Create Stage](7.png)


API Gateway でカスタムドメインを作成します。

![Create Custom Domain](8.png)


API マッピングです。

![API Mapping](9.png)


ルーティングポリシーを設定。

![Create Record](10.png)


ルーティングポリシーを設定。

![Create Record](11.png)

![Create Record](12.png)

![Create Record](13.png)

`https://api-gateway.swiswiswift.com/` にアクセスしてレスポンスが帰ることを確認します。

![Create Record](14.png)
