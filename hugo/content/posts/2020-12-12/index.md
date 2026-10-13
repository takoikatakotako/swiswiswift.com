+++
title =  "SwiftUIでAVAudioPlayerで音楽を再生し、再生終了を検知する"
url = "2020-12-12"
date = "2020-12-12"
description = "SwiftUIでAVAudioPlayerで音楽を再生し、再生終了を検知する"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/12"
+++

<br>

SwiftUIでAVAudioPlayerで音楽を再生し、再生終了を検知する方法です。
SwiftUIは struct を使うので AVAudioPlayerDelegate に準拠することができません。
そのため、ViewModel を作成し、SwiftUI（View）から呼び出してあげるます。

参考: [AVAudioPlayerDelegate SwiftUI](https://www.hackingwithswift.com/forums/swiftui/avaudioplayerdelegate-swiftui/2872)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @ObservedObject var viewModel = ContentViewModel()
    var body: some View {
        VStack {
            Button("Play") {
                viewModel.playAudio()
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


**ContentViewModel.swift**

```swift
import Foundation
import AVFoundation

class ContentViewModel: NSObject, ObservableObject, AVAudioPlayerDelegate {
    var audioPlayer: AVAudioPlayer?

    func playAudio() {
        guard let url = Bundle.main.url(forResource: "melody", withExtension: "mp3") else { return }
        audioPlayer = try! AVAudioPlayer(contentsOf: url)
        audioPlayer?.delegate = self
        audioPlayer?.play()
    }

    func audioPlayerDidFinishPlaying(_ player: AVAudioPlayer, successfully flag: Bool) {
        print("Did finish Playing")
    }
}
```

