+++
title =  "Dockerで Alpineベースのコンテナに入る"
url = "2019-12-21"
date = "2019-12-21"
description = "Dockerで Alpineベースのコンテナに入る"
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

Docker コンテナの中に入ってシェルを使いたい時ありますよね。
普通は以下のようなコマンドでコンテナの中に入るのですが、Alpine ベースの時は bash の代わりに ash を使って入ります。

```
$ docker run --rm -t -i centos:centos7 /bin/bash
```

```
$ docker run --rm -t -i alpine:latest /bin/ash
```


参考  
[Dockerコンテナのシェルの中に入る](https://qiita.com/__cooper/items/4740c24666299c366044)
[dockerでalpine linux ベースのcontainerに入って、shellを使いたいとき。](https://qiita.com/yutachaos/items/56dd7ea09d7e2b0d9173)

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
