+++
title =  "SwiftUIでFirestoreの画像を表示する"
url = "2020-02-08"
date = "2020-02-08"
description = "SwiftUIでFirestoreの画像を表示する"
tags = ["Firebase", "Swift", "SwiftUI"]
categories = ["Firebase", "Swift", "SwiftUI"]
archives = "2020/02"
+++

<br>

SwiftUI で Firestore の画像を表示する方法です。
UIImage は SDWebImage を使えば簡単に表示できますが、SwiftUI ではそれができません。
[SDWebImage/SDWebImageSwiftUI](https://github.com/SDWebImage/SDWebImageSwiftUI)を使って以下のように書いてみました。
もっと良い書き方がある気がします、これだとトークンも含めてキャッシュされちゃうような。。。

参考:
[iOS でファイルをダウンロードする](https://firebase.google.com/docs/storage/ios/download-files?hl=ja)
[SDWebImage/SDWebImageSwiftUI](https://github.com/SDWebImage/SDWebImageSwiftUI)


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ProfileCell.swift**

```swift
import SwiftUI
import UIKit
import SDWebImageSwiftUI
import FirebaseStorage

struct ProfileCell: View {
    let profile: Profile
    @State var urlString: String = ""
    var body: some View {
        ZStack {
            WebImage(url: URL(string: self.urlString))
                .resizable()
                .placeholder {
                    Image("profile")
                        .resizable()
            }
            .animation(.easeInOut(duration: 0.5))
            .transition(.fade)
            .scaledToFill()

            VStack {
                Spacer()
                Text(profile.name)
                    .font(Font.system(size: 20.0).bold())
                    .frame(maxWidth: .infinity, maxHeight: 32)
                    .background(Color.gray)
                    .foregroundColor(Color.white)
                    .opacity(0.8)
            }
        }.onAppear {
            self.featchImageUrl()
        }
    }

    func featchImageUrl() {
        let storage = Storage.storage()
        let pathReference = storage.reference(withPath: "character/\(profile.id)/profile.png")
        pathReference.downloadURL { url, error in
            if let error = error {
                // Handle any errors
                print(error)
            } else {
                guard let urlString = url?.absoluteString else {
                    return
                }
                self.urlString = urlString
            }
        }
    }
}
```

