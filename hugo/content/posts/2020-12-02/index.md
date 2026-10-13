+++
title =  "SwiftでSpringBootで作られたAPIに文字列を渡す"
url = "2020-12-02"
date = "2020-12-02"
description = "SwiftでSpringBootで作られたAPIに文字列を渡す"
tags = ["Java", "Spring", "Swift"]
categories = ["Java", "Spring", "Swift"]
archives = "2020/12"
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

<!--more-->

**Playground.swift**

```swift
import PlaygroundSupport
import XCPlayground

enum HttpMethod: String {
    case get = "GET"
    case post = "POST"
}

struct APIRequest {
    static func createUrlRequest<RequestBody: Encodable>(baseUrl: String = "https://swiswiswift.com/", path: String, httpMethod: HttpMethod = .get, requestHeader: [String: String] = ["Content-Type": "application/json"], requestBody: RequestBody) -> URLRequest {
        let url = URL(string: baseUrl + path)!
        var request = URLRequest(url: url)
        request.httpMethod = httpMethod.rawValue
        request.allHTTPHeaderFields = requestHeader
        if let httpBody = try? JSONEncoder().encode(requestBody) {
            request.httpBody = httpBody
        }
        return request
    }
}

struct SampleBean: Codable {
    let text: String
}

let request = APIRequest.createUrlRequest(baseUrl: "http://localhost:8080/" ,path: "sample", httpMethod: .post, requestBody: "Kabigon")
let task = URLSession.shared.dataTask(with: request) { data, response, error in
    guard let data = data, let response = response as? HTTPURLResponse else {
        return
    }
    
    let sampleBean = try! JSONDecoder().decode(SampleBean.self, from: data)
    print(sampleBean.text)  // -> "Kabigon"
}
task.resume()
```


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

**Playground.swift**

```swift
let request = APIRequest.createUrlRequest(baseUrl: "http://localhost:8080/" ,path: "sample", httpMethod: .post, requestBody: SampleBean(text: "Kabigon"))
let task = URLSession.shared.dataTask(with: request) { data, response, error in
    guard let data = data, let response = response as? HTTPURLResponse else {
        return
    }
    
    let sampleBean = try! JSONDecoder().decode(SampleBean.self, from: data)
    print(sampleBean.text)  // Kabigon
}
task.resume()
```



```
curl "http://localhost:8080/sample" \
	-X POST \
	-H 'Content-Type: application/json' \
	-d '{"text":"Kabigon"}'
```





