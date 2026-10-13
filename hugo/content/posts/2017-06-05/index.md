+++
title = "Swiftで音楽を再生する"
url = "2017-06-05"
date = "2017-06-05"
description = "Swiftで音楽を再生する"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/06"
+++

<br>

Swiftで音楽を簡単に再生するサンプルコードです。
リピート再生も簡単にできました。
サンプルコードにはないですが、ちゃんとエラーハンドリングしましょう。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**PlayMusic.swift**

```swift
import UIKit
import AVFoundation

class ViewController: UIViewController {

    var audioPlayer : AVAudioPlayer!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let soundFilePath : String = Bundle.main.path(forResource: "BGM_a", ofType: "mp3")!
        let fileURL : URL = URL(fileURLWithPath: soundFilePath)
        
        do{
            audioPlayer = try AVAudioPlayer(contentsOf: fileURL)
        }
        catch{
        }
        
        //numberOfLoopsに-1を指定すると無限ループする。
        audioPlayer.numberOfLoops = -1
        audioPlayer.play()
    }
}

```

