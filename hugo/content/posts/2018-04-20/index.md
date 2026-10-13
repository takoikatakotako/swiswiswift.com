+++
title = "現在の日付と曜日、現在時間を取得する"
url = "2018-04-20"
date = "2018-04-20"
description = "現在の日付と曜日、現在時間を取得する"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2018/04"
+++

<br>

Swift4.1で現在の日付と曜日、現在時間を取得するサンプルコードです。  
以下の形式の文字列で取得してくれます。  

2018/04/03 (木)  
19:03:34  

上のような形式で取得するサンプルコードです。  

Calendar.currentで取得すると、設定によっては和暦(平成〇〇年)で取得してしまう可能性があるので(2018/04/03が欲しいのに30/04/03が帰ってくる)、グレゴリオ暦で取得する方が無難です。  
逆に和暦が欲しいときは和暦で取得する方法もあります。  

このサイトが詳しいです。  
[Swift 3 の日時操作チートシート](https://qiita.com/mishimay/items/8d67b583dc6809b2baf5)  

その他参考にさせていただいたサイト  
[Swift3での日時に関する処理](https://qiita.com/isom0242/items/e83ab77a3f56f66edd2f)  
[【Swift3】現在時刻の取得とDataFormatterでの文字列化](https://qiita.com/GDaigo/items/270e6ed6e898e8b8e1c3)  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .white
        print(getDateString())  //2018/05/10 (木)
        print(getDateString2()) //2018年5月10日
        print(getTimeString())  //09:27:08
    }

    func getDateString() -> String {
        let date = NSDate()
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy/MM/dd"
        let dateStr = formatter.string(from: date as Date)

        //あまり良く無い例
        /*
        let cal = NSCalendar(calendarIdentifier: .gregorian)
        let weeks = ["日","月","火","水","木","金","土"]
        let comp = cal?.components(NSCalendar.Unit.weekday, from: date as Date)
        let weekIdx = comp?.weekday
        var weekStr = weeks[weekIdx! - 1]
        */

        //ローカライズなどを考えてこっちを使おう！
        formatter.locale = NSLocale(localeIdentifier: "ja_JP") as Locale?
        formatter.dateFormat = DateFormatter.dateFormat(fromTemplate: "EEEEE", options: 0, locale:  Locale.current)
        let weekStr = formatter.string(from:  date as Date)
        return  dateStr + " (" + weekStr + ")"
    }

    func getDateString2() -> String {
        let date = NSDate()
        let formatter = DateFormatter()

        //あまり良く無い例
        //formatter.dateFormat = "yyyy年MM月dd日"
        //ローカライズなどを考えてこっちを使おう！
        formatter.dateFormat = DateFormatter.dateFormat(fromTemplate: "ydMMM", options: 0, locale: Locale(identifier: "ja_JP"))
        return formatter.string(from: date as Date)
    }

    func getTimeString() -> String {
        let date = NSDate()
        let formatter = DateFormatter()
        formatter.dateFormat = "HH:mm:ss"
        return formatter.string(from: date as Date)
    }
}
```

