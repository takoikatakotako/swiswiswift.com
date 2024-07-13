+++
title = "UINavigationControllerの戻るボタンの戻るを消す"
url = "2017-10-14"
date = "2017-10-14"
description = "UINavigationControllerの戻るボタンの戻るを消す"
tags = [
    "iOS",
]
categories = [
    "iOS",
]
archives = "2017/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

UINavigationControllerの戻るボタンの文字を消します。  
「＜戻る」を「＜」にします。  

```
let backButton = UIBarButtonItem(title: "", style: .plain, target: nil, action: nil)
self.navigationItem.backBarButtonItem = backButton
self.navigationController?.pushViewController(picDetailView, animated: true)
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}
