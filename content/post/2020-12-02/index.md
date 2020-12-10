+++
title =  "SwiftでSpringBootで作られたAPIに文字列を渡す"
url = "2020-12-02"
date = "2020-12-02"
description = "SwiftでSpringBootで作られたAPIに文字列を渡す"
tags = [
  "Spring", 
  "Java",
  "Swift"
]
categories = [
  "Spring", 
  "Java",
  "Swift"
]
archives = "2020/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

SwiftでSpringBootで作られたAPIに文字列を渡した時にちょっと詰まったのでそれの忘備録です。

```
@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public SampleBean request(@RequestBody String text) {
        SampleBean sampleBean = new SampleBean();
        sampleBean.setText(text);
        return sampleBean;
    }
```

```
@Data
public class SampleBean implements Serializable {
    private String text;
}
```

このような Bean を返すエンドポイントを作りました。curl コマンドでエンドポイントを叩くと以下のようなレスポンスが返ってきます。想定通りの挙動です。

```
curl "http://localhost:8080/sample" \
  -X POST \
  -H 'Content-Type: application/json' \
	-d 'Kabigon' \
  | jq
```

```
{
  "text": "Kabigon"
}
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

次にこのエンドポイントを Swift から叩きます。

{{< gist takoikatakotako 015ea27acbfe10f1e90f7020489de6b7 >}}

レスポンスを SampleBean にデコードしてその中の text プロパティを表示すると ダブルクオート付きの文字列が表示されてしまいます。
それはSwift がダブルクオートを含めて Spring 側にデータを送信しているからです。
Swiftが行っているリクエストを curl コマンドに翻訳すると以下になります。

```
curl "http://localhost:8080/sample" \
	-X POST \
	-H 'Content-Type: application/json' \
	-d '"Kabigon"'
```

将来的に送りたいプロパティが増えるので、Swiftから String 型ではなく、任意の struct を送信するようにしました。

{{< gist takoikatakotako c9ced18b58e919e194895e6d433ac9c5 >}}


```
curl "http://localhost:8080/sample" \
	-X POST \
	-H 'Content-Type: application/json' \
	-d '{"text":"Kabigon"}'
```





