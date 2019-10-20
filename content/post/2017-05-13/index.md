+++
title = "音声認識(SFSpeechRecognizer)"
url = "2017-05-13"
date = "2017-05-13"
description = "Guide to emoji usage in Hugo"
tags = [
    "iOS",
]
categories = [
    "themes",
    "syntax",
]
archives = "2019/09"
aliases = ["migrate-from-jekyl"]
+++

<br>

iOS10からSpeech Frameworkが登場しました。ここではSFSpeechRecognizerを使って音声認識をしてみようと思います。そしてシミュレーターでは動かないから気をつけてください。



参考:AppleDeveloper:SpeakToMe: Using Speech Recognition with AVAudioEngine
参考:あたも開発ブログ
参考:【iOS 10】Speechフレームワークで音声認識 – 対応言語リスト付き

プライバシー設定をinfo.plistに記入

iOS10になってから、プライバシーに関する機能(通知、カメラ、フォトライブラリへのアクセス)を使う際に、Info.plistにあらかじめ使うことを書いておかないとアプリが落ちてしまうようになりました。音声認識機能を使う場合は以下のプライバシー設定を行う必要があります。

参考:アプリ開発ブログ（仮）

info.plistを開き、
Privacy – Speech Recognition Usage DescriptionをStringで追加し、右側に使用目的を記入します。
Privacy – Microphone Usage Description to practice programingもまたStringで追加し、右側に使用目的を記入します。使用目的が書かれていないと審査で落とされるらしいです。





サンプルコード

音声認識の結果をAlertで表示するプログラムです。

<script src="https://gist.github.com/O-Junpei/cecd673920cab46a0bcfc67162f43fe4.js"></script>