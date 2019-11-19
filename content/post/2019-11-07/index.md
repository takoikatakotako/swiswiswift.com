+++
title =  "PHP で本当に簡単なモックサーバーを作る"
url = "2019-11-07"
date = "2019-11-07"
description = "PHP で本当に簡単なモックサーバーを作る"
tags = [
    "PHP",
]
categories = [
    "PHP",
]
archives = "2019/11"
aliases = ["migrate-from-jekyl"]
+++

<br>
ローカルにモックサーバーが必要だったので簡単なものをPHPで作ってみました。  
`signup.php` でユーザー登録を行い、`list.php` でユーザーの一覧を表示し、`deleate.php` でユーザーを全て削除します。

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

{{< highlight html >}}
# サーバー起動
$ php -S localhost:8000
{{< /highlight >}}

{{< highlight html >}}
# ユーザー登録
$ curl http://localhost:8000/signup.php -X POST -H "Content-Type: application/json" -d '{"name":"onojun", "age":24}'
{{< /highlight >}}

{{< highlight html >}}
# ユーザー一覧
$ curl http://localhost:8000/list.php
{{< /highlight >}}

{{< highlight html >}}
# 全てのユーザーを削除
$ curl http://localhost:8000/deleate.php
{{< /highlight >}}

<script src="https://gist.github.com/O-Junpei/75bce07d6d7600a0b09b947bd45332ed.js"></script>
