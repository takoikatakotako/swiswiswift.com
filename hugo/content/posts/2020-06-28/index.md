+++
title =  "よくあるチュートリアル画面をUIPageViewControllerとSwiftUIで作る"
url = "2020-06-28"
date = "2020-06-28"
description = "よくあるチュートリアル画面をUIPageViewControllerとSwiftUIで作る"
tags = ["iOS", "Swift", "SwiftUI"]
categories = ["iOS", "SwiftUI"]
archives = "2020/06"
+++

<br>

UIPageViewControllerとSwiftUIでよくあるチュートリアル画面を作ります。
画面をスワイプすると次の画面が表示されます。

![PageViewController](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    @State var views = [
        TutorialView(imageName: "snorlax", text: "First"),
        TutorialView(imageName: "pikachu", text: "Second"),
        TutorialView(imageName: "slowpoke", text: "Third"),
        TutorialView(imageName: "coil", text: "Fourth"),
    ]
    
    var body: some View {
        PageView(views)
            .background(Color.gray)
            .edgesIgnoringSafeArea(.all)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
```


**PageControl.swift**

```swift
import SwiftUI
import UIKit

struct PageControl: UIViewRepresentable {
    var numberOfPages: Int
    @Binding var currentPage: Int

    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }

    func makeUIView(context: Context) -> UIPageControl {
        let control = UIPageControl()
        control.numberOfPages = numberOfPages
        control.addTarget(
            context.coordinator,
            action: #selector(Coordinator.updateCurrentPage(sender:)),
            for: .valueChanged)

        return control
    }

    func updateUIView(_ uiView: UIPageControl, context: Context) {
        uiView.currentPage = currentPage
    }

    class Coordinator: NSObject {
        var control: PageControl

        init(_ control: PageControl) {
            self.control = control
        }

        @objc
        func updateCurrentPage(sender: UIPageControl) {
            control.currentPage = sender.currentPage
        }
    }
}
```


**PageView.swift**

```swift
import SwiftUI

struct PageView<Page: View>: View {
    var viewControllers: [UIHostingController<Page>]
    @State var currentPage = 0
    
    init(_ views: [Page]) {
        self.viewControllers = views.map { UIHostingController(rootView: $0) }
    }
    
    var body: some View {
        ZStack(alignment: .bottom) {
            PageViewController(controllers: viewControllers, currentPage: $currentPage)
            PageControl(numberOfPages: viewControllers.count, currentPage: $currentPage)
                .padding(.trailing)
                .padding(.bottom, 20)
        }
    }
}

struct PageView_Previews: PreviewProvider {
    struct PreviewWrapper: View {
        @State var views = [Text("First"), Text("Second"), Text("Third")]
        var body: some View {
            PageView(views)
        }
    }
    
    static var previews: some View {
        PreviewWrapper()
    }
}
```


**PageViewController.swift**

```swift
import SwiftUI
import UIKit

struct PageViewController: UIViewControllerRepresentable {
    var controllers: [UIViewController]
    @Binding var currentPage: Int
    
    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    func makeUIViewController(context: Context) -> UIPageViewController {
        let pageViewController = UIPageViewController(
            transitionStyle: .scroll,
            navigationOrientation: .horizontal)
        pageViewController.dataSource = context.coordinator
        pageViewController.delegate = context.coordinator
        
        return pageViewController
    }
    
    func updateUIViewController(_ pageViewController: UIPageViewController, context: Context) {
        pageViewController.setViewControllers(
            [controllers[currentPage]], direction: .forward, animated: true)
    }
    
    class Coordinator: NSObject, UIPageViewControllerDataSource, UIPageViewControllerDelegate {
        var parent: PageViewController
        
        init(_ pageViewController: PageViewController) {
            self.parent = pageViewController
        }
        
        func pageViewController(
            _ pageViewController: UIPageViewController,
            viewControllerBefore viewController: UIViewController) -> UIViewController?
        {
            guard let index = parent.controllers.firstIndex(of: viewController) else {
                return nil
            }
            
            if index == 0 {
                return nil
            }
            return parent.controllers[index - 1]
        }
        
        func pageViewController(
            _ pageViewController: UIPageViewController,
            viewControllerAfter viewController: UIViewController) -> UIViewController?
        {
            guard let index = parent.controllers.firstIndex(of: viewController) else {
                return nil
            }
            
            if index + 1 == parent.controllers.count {
                return nil
            }
            return parent.controllers[index + 1]
        }
        
        func pageViewController(_ pageViewController: UIPageViewController, didFinishAnimating finished: Bool, previousViewControllers: [UIViewController], transitionCompleted completed: Bool) {
            if completed,
                let visibleViewController = pageViewController.viewControllers?.first,
                let index = parent.controllers.firstIndex(of: visibleViewController)
            {
                parent.currentPage = index
            }
        }
    }
}
```


**TutorialView.swift**

```swift
import SwiftUI

struct TutorialView: View {
    let imageName: String
    let text: String
    var body: some View {
        VStack(alignment: .center) {
            Spacer()
            Text(text)
            HStack {
                Image(imageName)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 200, height: 200)
                Spacer()
            }
            Spacer()
        }
        .background(Color.gray)
        .edgesIgnoringSafeArea(.all)
    }
}

struct TutorialView_Previews: PreviewProvider {
    static var previews: some View {
        TutorialView(imageName: "snorlax", text: "This is Tutorial!")
    }
}
```

