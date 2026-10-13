+++
title = "SwiftUIでUIActivityViewControllerを表示する"
url = "2023-12-20"
date = "2023-12-20"
description = "SwiftUIでUIActivityViewControllerを表示する"
tags = ["Swift", "SwiftUI"]
categories = ["SwiftUI"]
archives = "2023/12"
+++

<br>

SwiftUIでUIActivityViewControllerを表示する方法です。

<img src="2023-12-20.gif" width="300px" alt="SwiftUIでUIActivityViewControllerを表示する">

<!--more-->

**ActivityViewController.swift**

```swift
import SwiftUI

struct ActivityViewController: UIViewControllerRepresentable {
    var activityItems: [Any]
    var applicationActivities: [UIActivity]? = nil
    
    func makeUIViewController(context: UIViewControllerRepresentableContext<ActivityViewController>) -> UIActivityViewController {
        let controller = UIActivityViewController(activityItems: activityItems, applicationActivities: applicationActivities)
        return controller
    }
    
    func updateUIViewController(_ uiViewController: UIActivityViewController, context: UIViewControllerRepresentableContext<ActivityViewController>) {}
}
```


**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State private var showingActivityIndicator: Bool = false
    var body: some View {
        Button("Share swiswiswift.com") {
            showingActivityIndicator = true
        }
        .sheet(isPresented: $showingActivityIndicator) {
            ActivityViewController(activityItems: [URL(string: "https://swiswiswift.com")!])
        }
    }
}

#Preview {
    ContentView()
}
```

