+++
title =  "SwiftUIでStructが使いまわされる"
url = "2019-11-14"
date = "2019-11-14"
description = "SwiftUIでStructが使いまわされる"
tags = [
    "iOS", "Swift"
]
categories = [
    "iOS", "Swift"
]
archives = "2019/11"
aliases = ["migrate-from-jekyl"]
+++

<br>
画面遷移をするたびに異なる ID を表示させたかったのですが、それができませんでした。（毎回同じ ID が表示される）

![同じIDが表示される](1.gif)

`onDisappear` で id を再生成することで回避しました。  
`@State` に変化が無い場合はキャッシュを使い回したりするということでしょうか？   
勉強していきます！！

![同じIDが表示される](2.gif)

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

{{< gist O-Junpei 8fa1b637dcc404f99c78f4c2af84c2a4 >}}
