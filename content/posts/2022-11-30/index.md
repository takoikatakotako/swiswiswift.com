+++
title = "pkill（LPIC）"
url = "2022-11-30"
date = "2022-11-30"
description = "pkill（LPIC）"
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

# pkill


## サンプル

### nginxを終了させる

```
$ ps ax | grep nginx
```

```
   5241 ?        Ss     0:00 nginx: master process /usr/sbin/nginx
   5242 ?        S      0:00 nginx: worker process
   5244 pts/0    S+     0:00 grep --color=auto nginx
```

```
$ pkill nginx
``

```
$ ps ax | grep nginx
```

```
   5249 pts/0    S+     0:00 grep --color=auto nginx
```

5241, 5242, 5244 のプロレスが終了していることがわかります。
5249　のプロセスは終了した後にできたプロセスだと思います。
