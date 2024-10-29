+++
title = "Appleのエンジニアさんにコードレベルの質問を送ってみた"
url = "2018-05-21"
date = "2018-05-21"
description = "Appleのエンジニアさんにコードレベルの質問を送ってみた"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2018/05"
aliases = ["migrate-from-jekyl"]
+++

<br>

「AppleDeveloperの登録料が高すぎる」と友達からよく言われるんですが、高いだけあって良いところもたくさんあります。  
その中の一つがTechnical Support Incident（TSI）で、修正できないバグや問題をコードのレベルでAppleのエンジニアさんが質問に答えてくれたり、相談に乗ってくれます。  
AppleDeveloperProgramを登録or更新すると2回テクニカルサポートの権利がもらえます。  

以前、目覚まし時計のアプリを作っており、その途中で解決できないバグがありました。  
具体的には「iPhoneのロック中に通知の音が鳴らない」というもので、シミュレーターでは動くのに、実機ではそのバグが現れます。  
自分では解決できなかったため、DTIを使うことにしました。  

まず、バグの部分を切り出したXcodeのプロジェクトを作り、githubに上げました。  
次に「タイトル」、「バグの説明」、「再現手順」、「(リリース済みアプリの場合は)App NameとApp ID」を英語で書き、アカウントページの Code-Level Support のフォーム(https://developer.apple.com/account/?view=support)から送りました。  
すぐに自動返信メールがくるので、そのメールにバグの部分を切り出したXcodeのプロジェクト(github に上げたものと同じもの)を添付して返信しました。  

２日後にAppleのエンジニアさんから返事が届きました。  
「Xcodeプロジェクトと再現手順ありがとう！君の手順どうりにやったんだけど、僕の環境ではバグは出なかったよ。他の端末でチェックしてみて」といった内容で、妻と友達の端末を借りて動かしたらちゃんと動きました。  
僕のiPhoneが壊れていたみたいです。。。orz  

つまらないオチですが、Appleのエンジニアさんが実際にコードを動かして試してくれるのはとてもありがたく、本当に詰まった時はありがたいなと思いました。  

それでは良いSwiftライフをーー！  

AppleDeveloper -テクニカルサポートのリクエスト-  
https://developer.apple.com/jp/support/technical/  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
