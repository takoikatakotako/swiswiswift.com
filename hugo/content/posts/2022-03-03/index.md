+++
title =  "SwiftUIでのプッシュ通知の最小構成"
url = "2022-03-03"
date = "2022-03-03"
description = "SwiftUIでのプッシュ通知の最小構成"
tags = ["AWS", "Swift", "SwiftUI"]
categories = ["AWS"]
archives = "2022/03"
+++

<br>

SwiftUIでのプッシュ通知の最小構成です。
プッシュ通知のテストをしたい時に使用します。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**AppDelegate.swift**

```swift
import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Show Push Notification Dialogue
        UNUserNotificationCenter.current().requestAuthorization(options: [.alert, .sound, .badge]) { granted, error in
            guard granted else { return }
            DispatchQueue.main.async {
                UIApplication.shared.registerForRemoteNotifications()
            }
        }
        UNUserNotificationCenter.current().delegate = self
        
        return true
    }
    
    // MARK: UISceneSession Lifecycle
    
    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }
    
    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }    
}

extension Notification.Name {
    static let deviceToken = Notification.Name("DeviceToken")
}

extension AppDelegate: UNUserNotificationCenterDelegate {
    func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
        let token = deviceToken.map { String(format: "%.2hhx", $0) }.joined()
        print("Device token: \(token)")
        NotificationCenter.default.post(name: .deviceToken, object: token)
    }
    
    func application(_ application: UIApplication, didReceiveRemoteNotification payload: [AnyHashable: Any]) {
        print(payload)
    }
    
    func userNotificationCenter(_ center: UNUserNotificationCenter, willPresent notification: UNNotification, withCompletionHandler completionHandler: @escaping (UNNotificationPresentationOptions) -> Void) {
        completionHandler([.sound, .badge])
    }
}
```


**ContentView.swift**

```swift
import SwiftUI

struct ContentView: View {
    let publisher = NotificationCenter.default.publisher(for: .deviceToken)
    @State var deviceToken: String = ""
    
    var body: some View {
        VStack {
            Text("DeviceToken")
            TextField("Device Token is Empty", text: $deviceToken)
                .padding()
        }
        .onReceive(publisher) { message in
            if let deviceToken = message.object as? String {
                self.deviceToken = deviceToken
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .previewDevice(PreviewDevice(rawValue: "iPhone 13"))
            .previewDisplayName("iPhone 13")
    }
}

```


