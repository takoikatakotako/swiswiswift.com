+++
title = "TableViewのセルの高さを変更する（Swift5.0.1）"
url = "2019-07-30"
date = "2019-07-30"
description = "TableViewのセルの高さを変更する（Swift5.0.1）"
tags = [
    "iOS",
    "Swift5",
]
categories = [
    "Swift",
    "iOS",
]
archives = "2019/07"
aliases = ["migrate-from-jekyl"]
+++

<br>
TableView のセルの高さを変更する方法です。  
一括で帰るときは .rowHeight を使い、個別に変えたいときは　heightForRowAt　を使うと実現できました。

サンプルコードはこちら。  
[https://github.com/O-Junpei/swiswiswift-ios](https://github.com/O-Junpei/swiswiswift-ios)


![alt](1.png)

<!-- for swiswiswift.com responsive -->
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

<iframe style="width:120px;height:240px;" marginwidth="0" marginheight="0" scrolling="no" frameborder="0" src="https://rcm-fe.amazon-adsystem.com/e/cm?ref=qf_sp_asin_til&t=swiswiswift-22&m=amazon&o=9&p=8&l=as1&IS1=1&detail=1&asins=4797398558&linkId=ceb2ab5d87e914e561733d50690e15da&bc1=ffffff&lt1=_top&fc1=333333&lc1=0066c0&bg1=ffffff&f=ifr"></iframe>

<br>

<script src="https://gist.github.com/O-Junpei/52393a8847f0c50a4ef6a8253aabd61d.js"></script>
