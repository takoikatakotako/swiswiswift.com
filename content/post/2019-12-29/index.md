+++
title =  "StoryboardsをiOS13以上のプロジェクトから削除する"
url = "2019-12-29"
date = "2019-12-29"
description = "StoryboardsをiOS13以上のプロジェクトから削除する"
tags = [
    "Docker"
]
categories = [
    "Docker"
]
archives = "2019/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

`Swift` & `Storyboard` でファイルを作成します。
`Main.storyboard` を削除します。

![Delete Storyboard](1.png)

`Main storyboard file base name` の項を削除する。

![Delete Main In Info.plist](2.png)

`Application Scene Manifest` -> `Application Session Role` -> `Item0` -> `Storyboard Name` を削除する。


<!-- for swiswiswift.com responsive -->
<script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-5587141252700968"
     data-ad-slot="1697863134"
     data-ad-format="auto"
     data-adtest="on"
     data-full-width-responsive="true"></ins>
<script>
     (adsbygoogle = window.adsbygoogle || []).push({});
</script>
<!-- for swiswiswift.com responsive -->

<!-- for swiswiswift-22 search -->
<script type="text/javascript">amzn_assoc_ad_type ="responsive_search_widget"; amzn_assoc_tracking_id ="swiswiswift-22"; amzn_assoc_marketplace ="amazon"; amzn_assoc_region ="JP"; amzn_assoc_placement =""; amzn_assoc_search_type = "search_widget";amzn_assoc_width ="auto"; amzn_assoc_height ="auto"; amzn_assoc_default_search_category =""; amzn_assoc_default_search_key ="";amzn_assoc_theme ="light"; amzn_assoc_bg_color ="FFFFFF"; </script><script src="//z-fe.amazon-adsystem.com/widgets/q?ServiceVersion=20070822&Operation=GetScript&ID=OneJS&WS=1&Marketplace=JP"></script>
<!-- for swiswiswift-22 search -->


![Delete Storyboard Name](3.png)

`SceneDelegate.swift` で表示する ViewController を設定します。

```
func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
    guard let windowScene = (scene as? UIWindowScene) else { return }
    window = UIWindow(frame: UIScreen.main.bounds)
    let viewController = ViewController()
    window?.rootViewController = viewController
    window?.makeKeyAndVisible()
    window?.windowScene = windowScene
}
```

参考  
[Creating Apps Without Storyboards in iOS 13](https://medium.com/better-programming/creating-apps-without-storyboards-in-ios-13-fc9550bb9c12)
