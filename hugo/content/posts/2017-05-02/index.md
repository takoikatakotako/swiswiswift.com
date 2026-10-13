+++
title = "Dictionary"
url = "2017-05-02"
date = "2017-05-02"
description = "Dictionary"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/05"
+++



<br>

Swiftの辞書配列です。
辞書配列の作成と呼び出しについて記載します。  
人によって辞書配列だったり、ハッシュだったり、マップだったりと、言い方が違うのが好きです。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**DictionaryBasicSample.swift**

```swift
import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 初期化
        var personDic: Dictionary<String, String> = ["height": "168", "wheight": "61", "like": "kabigon"]
        print(personDic)    
        //["wheight": "61", "height": "168", "like": "kabigon"]
        
        // データ追加
        personDic["age"] = "24"
        print(personDic)   
        //["wheight": "61", "height": "168", "age": "24", "like": "kabigon"]

        //　任意のキーの値を取り出す
        //存在しないキーにアクセスすると、?? 以降が呼ばれる
        print(personDic["height"] ?? "200")    //168
        print(personDic["country"] ?? "japan")    //japan
        
        //要素数
        print(personDic.count) 
        //4
        
        // 辞書配列のKeyを取得する
        let personDickeys: Array = Array(personDic.keys)
        print(personDickeys)  //  
        ["wheight", "height", "age", "like"]
        
        //　辞書配列のValueを取得する
        let personDicValues: Array = Array(personDic.values)
        print(personDicValues)  
        //  ["61", "168", "24", "kabigon"]

        // 指定したkeyのデータを削除
        personDic.removeValue(forKey: "height")
        print(personDic) 
        //  ["wheight": "61", "age": "24", "like": "kabigon"]
        
    }
}
```

