+++
title = "date（LPIC）"
url = "2022-11-16"
date = "2022-11-16"
description = "date（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

# date



## サンプル

### 現在時間を表示

```
$ date
```

```
Tue Aug 23 05:19:08 PM JST 2022
```


### UTCで現在時刻を表示

```
$ date --utc
```

```
Tue Aug 23 08:19:39 AM UTC 2022
```


### タイムゾーンをNew_Yorkに指定してdateコマンドを実行する

```
$ TZ=New_York date
```


### タイムゾーンをUTCに指定してdateコマンドを実行する

```
$ TZ=UTC date
```

