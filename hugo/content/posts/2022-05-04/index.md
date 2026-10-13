+++
title =  "Pythonで別ファイルの関数を実行する"
url = "2022-05-04"
date = "2022-05-04"
description = "Pythonで別ファイルの関数を実行する"
tags = ["Python"]
categories = ["Python"]
archives = "2022/05"
+++

<br>

Pythonで別ファイルの関数を実行する方法です。
`functions.py` で定義した `hello()` を `main.py` で実行しています。

```
$ python main.py
```

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**functions.py**

```python
def hello():
    print('hello')
```


**main.py**

```python
import functions

def main():
    functions.hello()


if __name__ == '__main__':
    main()
```

