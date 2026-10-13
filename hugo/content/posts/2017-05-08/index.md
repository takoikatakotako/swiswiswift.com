+++
title = "現在時刻の取得"
url = "2017-05-08"
date = "2017-05-08"
description = "現在時刻の取得"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/05"
+++

<br>

現在時間を取得します。

[AppleDeveloperリファレンスNSCalender](https://developer.apple.com/documentation/foundation/nscalendar)

サンプルプログラム

以下に示します

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**GetNowTimes.swift**

```swift
import UIKit

class ViewController: UIViewController{
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //現在の時間を取得
        let date = Date()
        
        //取得する要素を選択する
        let calendar = Calendar.current
        let component = (calendar as NSCalendar).components([NSCalendar.Unit.year, NSCalendar.Unit.month, NSCalendar.Unit.day, NSCalendar.Unit.hour, NSCalendar.Unit.minute, NSCalendar.Unit.second, NSCalendar.Unit.weekday], from: date)
        
        // 日時と時間の出力
        print("西暦:"+String(component.year!))
        print("月:"+String(component.month!))
        print("日:"+String(component.day!))
        print("時:"+String(component.hour!))
        print("分:"+String(component.minute!))
        print("秒:"+String(component.second!))
        
        //曜日の出力
        let weeksAry: Array = ["nil","Sun.","Mon.","Tue.","Wed.","Thu.","Fri.","Sat.","Sun."]
        let weekDayInt:Int = component.weekday!
        print("曜日"+weeksAry[weekDayInt])
      }
}
```

