+++
title =  "Alamofireで受け取ったJsonをCodableを使ってパースする"
url = "2019-11-19"
date = "2019-11-19"
description = "Alamofireで受け取ったJsonをCodableを使ってパースする"
tags = ["iOS", "Swift"]
categories = ["iOS", "Swift"]
archives = "2019/11"
+++

<br>

[お天気Webサービス（Livedoor Weather Web Service）](http://weather.livedoor.com/weather_hacks/webservice) の API を Alamofire から叩き、帰ってきた JSON を struct にパースする方法です。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Alamofire-Codable-201900801.swift**

```swift
import UIKit
import Alamofire

class Weather: Codable {
    let title: String
    let link: String
    let description: Description
    let pinpointLocations: [PinpointLocation]
    let location: Location
    let forecasts: [Forcast]
}

struct Description: Codable {
    let text: String
    let publicTime: String
}

struct PinpointLocation: Codable {
    let link: String
    let name: String
}

struct Location: Codable {
    let city: String
    let area: String
    let prefecture: String
}

struct Forcast: Codable {
    let dateLabel: String
    let telop: String
    let date: String
    let image: Image
}

struct Image: Codable {
    let width: Int
    let url: String
    let title: String
    let height: Int
}


class Alamofire_Codable_201900801: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        view.backgroundColor = .white

        //お天気APIから東京の天気を取得する
        let url: String = "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010"
        Alamofire.request(url, method: .get, encoding: JSONEncoding.default).responseJSON { response in
            switch response.result {
            case .success:
                guard let data = response.data else { return }
                guard let weather = try? JSONDecoder().decode(Weather.self, from: data) else {
                    return
                }
                
                self.showWeatherAlert(weather: weather)
            case .failure(let error):
                print(error)
            }
        }
    }

    func showWeatherAlert(weather: Weather) -> Void {
        // アラートを作成
        let alert = UIAlertController(
            title: weather.title,
            message: weather.description.text,
            preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "OK", style: .default))

        present(alert, animated: true, completion: nil)
    }
}
```

