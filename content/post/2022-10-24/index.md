+++
title = "正規表現（LPIC）"
url = "2022-10-24"
date = "2022-10-24"
description = "正規表現（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

# 正規表現


##　サンプル

### 以下のようなファイルからNginxという文字列が入った行を抽出する

```
logNginx0
logNginx1
logApache0
logNginx2
logApache1
logDatadog0
```

```
$ grep -e 'logNginx[012]' file.txt
$ grep -e 'logNginx[0-2]' file.txt
```

```
logNginx0
logNginx1
logNginx2
```


### 以下のようなファイルから10時代のログを抽出する

```
2022-01-23 04:23:43 log
2022-01-26 04:23:43 log
2022-01-28 10:23:43 log
2022-01-30 04:23:43 log
2022-02-02 04:23:43 log
2022-04-23 10:23:43 log
```

```
$ grep -e '10:[0-5][0-9]' file.txt
```

```
2022-01-28 10:23:43 log
2022-04-23 10:23:43 log
```