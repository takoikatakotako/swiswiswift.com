+++
title =  "SwiftUIでAVAudioPlayerNodeで音楽を再生し、再生終了を検知する"
url = "2020-12-13"
date = "2020-12-13"
description = "SwiftUIでAVAudioPlayerNodeで音楽を再生し、再生終了を検知する"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/12"
+++

<br>

SwiftUIでAVAudioPlayerNodeで音楽を再生し、再生終了を検知する方法です。
AVAudioPlayer は Delegate で再生終了を検知しますが、AVAudioPlayerNodeは再生終了時に呼ばれるハンドラーが用意されているのでそちらを使います。

参考: [AVAudioEngine & AVAudioPlayerNode didFinish method like AVAudioPlayer](https://stackoverflow.com/questions/34238432/avaudioengine-avaudioplayernode-didfinish-method-like-avaudioplayer)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI
import AVFoundation

struct ContentView: View {
    @State var audioPlayerNode = AVAudioPlayerNode()
    @State var audioEngine = AVAudioEngine()
    @State var speedControl = AVAudioUnitVarispeed()
    @State var pitchControl = AVAudioUnitTimePitch()
    
    var body: some View {
        VStack {
            HStack {
                Button("Start") {
                    guard let url = Bundle.main.url(forResource: "melody", withExtension: "wav") else { return }
                    guard let file = try? AVAudioFile(forReading: url) else { return }
                    
                    audioPlayerNode = AVAudioPlayerNode()
                    
                    audioEngine.attach(audioPlayerNode)
                    audioEngine.attach(pitchControl)
                    audioEngine.attach(speedControl)
                    
                    audioEngine.connect(audioPlayerNode, to: speedControl, format: nil)
                    audioEngine.connect(speedControl, to: pitchControl, format: nil)
                    audioEngine.connect(pitchControl, to: audioEngine.mainMixerNode, format: nil)
                    audioPlayerNode.scheduleFile(file, at: nil) {
                        print("Did Finish")
                    }
                    try? audioEngine.start()
                    audioPlayerNode.play()
                }.padding()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```

