+++
title = "Alamofireを使ってAPIからJSONを取得する"
url = "2017-07-09"
date = "2017-07-09"
description = "Alamofireを使ってAPIからJSONを取得する"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/07"
+++

<br>

新しい記事(Swift4)はこちらAlamofireを使ってAPIからJSONを取得する(Swift4.2)  

swiftの有名な通信ライブラリである [Alamofire](https://github.com/Alamofire/Alamofire) とこれまたSwiftで有名なJSONを扱うライブラリであるSwiftyJSONを使って、[お天気API](http://weather.livedoor.com/weather_hacks/webservice) から情報を取得するサンプルです。  
今回のサンプルでは非同期でJSONを取得し、アラートを表示します。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit
import Alamofire
import SwiftyJSON

class ViewController: UIViewController {
    

    override func viewDidLoad() {
        super.viewDidLoad()
        
        //お天気APIから東京の天気を取得する
        let url:String = "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010"
        Alamofire.request(url, method: .get, encoding: JSONEncoding.default).responseJSON{ response in
            
            switch response.result {
            case .success:
                let json:JSON = JSON(response.result.value ?? kill)
                print(json["title"])
                print(json["description"]["text"])
                self.showWeatherAlert(title: json["title"].stringValue,message: json["description"]["text"].stringValue)
            case .failure(let error):
                print(error)
            }
        }
    }
    

    func showWeatherAlert(title:String,message:String) -> Void {
        
        // アラートを作成
        let alert = UIAlertController(
            title: title,
            message: message,
            preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        
        // アラート表示
        self.present(alert, animated: true, completion: nil)
    }
}
```

