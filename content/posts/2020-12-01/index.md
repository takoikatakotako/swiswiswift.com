+++
title =  "SpringBootでBeanを返すとプロパティ名のisが省略される"
url = "2020-12-01"
date = "2020-12-01"
description = "SpringBootでbooleanを返すとプロパティ名のisが省略される"
tags = [
  "Spring", "Java"
]
categories = [
  "Spring", "Java"
]
archives = "2020/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

SpringBoot で boolean型 で isXXX という名前のプロパティを持つ Bean を返すとisが省略されたので、それ周りの挙動の確認のメモです。

```
@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
public SampleBean request() {
    SampleBean sampleBean = new SampleBean();
    sampleBean.setName("Kabigon");
    sampleBean.setStudent(false);
    sampleBean.setIsHuman(true);
    return sampleBean;
}
```

```
@Data
public class SampleBean implements Serializable {
    private String name;
    private boolean isStudent;
    private Boolean isHuman;
}
```

このような Bean を返すエンドポイントを作り、curl コマンドでそのエンドポイントを叩きます。

```
curl "http://localhost:8080/" \
  -X GET \
  -H 'Content-Type: application/json' \
  | jq
```

```
{
  "name": "Kabigon",
  "isHuman": true,
  "student": false
}
```

このような JSON が返ってきます。boolean型の isStudent は is が省略されています。


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}


次に SampleBean を受け取るようなエンドポイントを作成します。

```
@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
public SampleBean request(@RequestBody SampleBean sampleBean) {
    return sampleBean;
}
```

このエンドポイントは以下のように叩くことができます。リクエストボディのプロパティ名は student でも isStudent でも動大丈夫です。。

```
curl "http://localhost:8080/sample" \
  -X POST \
  -H 'Content-Type: application/json' \
	-d '{"name":"Kabigon","isHuman":true,"student":false}' \
  | jq
```

```
curl "http://localhost:8080/sample" \
  -X POST \
  -H 'Content-Type: application/json' \
	-d '{"name":"Kabigon","isHuman":true,"isStudent":false}' \
  | jq
```


```
{
  "name": "Kabigon",
  "isHuman": true,
  "student": false
}
```

