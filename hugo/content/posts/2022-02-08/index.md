+++
title =  "PythonでWebサイトのHTMLファイルを取得して保存する"
url = "2022-02-08"
date = "2022-02-08"
description = "PythonでWebサイトのHTMLファイルを取得して保存する"
tags = ["Python"]
categories = ["Python"]
archives = "2022/02"
+++

<br>

PythonでWebサイトのHTMLファイルを取得して保存する方法です。
urllibでGETアクセスし、レスポンスを文字列として保存しています。

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!-- Google Ads -->
{{< google-ads >}}

<!--more-->

**main.py**

```python
import urllib.request


def _fetch(url: str) -> str:
    request = urllib.request.Request(
        url = url,
        headers = {"User-Agent": "swiswiswift.com/1.0.0"},
        method = 'GET'
    )

    response = urllib.request.urlopen(request)
    print(f'StatusCode: {response.getcode()}')
    content_charset: str = response.headers.get_content_charset()
    print(f'Charset: {content_charset}')

    charsets: [str] = []
    charsets.append(content_charset)
    charsets.append('utf-8')
    charsets.append('ISO-8859-1')
    
    binary_body = response.read()

    for charset in charsets:
        try:
            content: str = binary_body.decode(charset)
            print(f'Success to decode by {charset}')
            return content
        except:
            print(f'Faild to decode by {charset}')

    raise Exception(f'Failed to decode: {url}')
        
    return content


def _save_file(html: str, path: str):
    fp = open(path, 'w', encoding='utf-8')
    fp.write(html)


def main():
    content: str = _fetch('https://swiswiswift.com/')
    _save_file(content, 'index.html')


if __name__ == '__main__':
    main()
```


