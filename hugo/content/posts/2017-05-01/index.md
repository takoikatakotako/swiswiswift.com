+++
title = "Array"
url = "2017-05-01"
date = "2017-05-01"
description = "Array"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/05"
+++



<br>

配列の書き方

Swiftの配列です。配列の作成と呼び出しについて記載します。


<!--more-->

**ArrayBasicSample.swift**

```swift
import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
        //配列の宣言
        let languages = ["Ruby","C","Swift","Python","Swift"]
        
        //繰り返して結果を出力
        for language in languages {
            print("\(language) ")    
            //Ruby C Swift Python Swift と出力される
        }
        
        //二番目の要素にアクセス
        print("二番目の要素にアクセス->\(languages[1]) ")   
        //二番目の要素にアクセス->C と出力される
        
        //一番最後の要素にアクセス
        print("二番目の要素にアクセス->\(languages.last) ")   
        //一番最後の要素にアクセス->Swift と出力される
        
        //要素数を数える
        print("languages配列の要素数は？->\(languages.count) ")     
        //programings配列の要素数は？->5
        
        //配列の中にある要素が含まれているのかを調べる
        let isContein:Bool = languages.contains("Python")
        print("isConteinの中身->\(isContein)")     
        //isConteinの中身->true
        
        //型明記(以下、INT型で宣言)
        var intArray:[Int] = [1,1,2,3,5,8,12,20]
        
        //配列の要素を足し算
        print("\(intArray[1] + intArray[2])")   
        //3 と出力される, 1+2
    }
}
```


配列の追加、挿入、削除

配列の追加、挿入、削除をしてみます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

**ArrayAddDeleteOtherSample.swift**

```swift
import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
        //配列の宣言
        var languages = ["Ruby","C","Swift","Python","Swift"]
        
        //要素の追加
        languages.append("lisp")
        print(languages)    
        //["Ruby", "C", "Swift", "Python", "Swift", "lisp"]
        
        //配列に要素を追加、先頭に挿入
        languages.insert("Java", at: 0)
        print(languages)    
        //["Java", "Ruby", "C", "Swift", "Python", "Swift", "lisp"]
        
        //配列に要素を追加、2番目に挿入
        languages.insert("JavaScript", at: 2)
        print(languages)    
        //["Java", "Ruby", "JavaScript", "C", "Swift", "Python", "Swift", "lisp"]
        
        //配列の反転
        languages = languages.reversed()
        print(languages)    //["lisp", "Swift", "Python", "Swift", "C", "JavaScript", "Ruby", "Java"]
        
        //ソート処理：降順
        languages = languages.sorted{ $0 < $1 };
        print(languages)    
        //["C", "Java", "JavaScript", "Python", "Ruby", "Swift", "Swift", "lisp"]
        
        //ソート処理：昇順
        languages = languages.sorted{ $1 < $0 }
        print(languages)    
        //["lisp", "Swift", "Swift", "Ruby", "Python", "JavaScript", "Java", "C"]
        
        //フィルタ（最初の文字が*の場合。以下はJの場合）
        let filteredLanguages = languages.filter {$0.hasPrefix("J")}
        print(filteredLanguages)    
        //["JavaScript", "Java"]
        
        //一番目の要素を削除
        languages.remove(at: 0)
        print(languages)    
        //["Swift", "Swift", "Ruby", "Python", "JavaScript", "Java", "C"]
        
        //最後の要素を削除
        languages.removeLast()
        print(languages)    
        //["Swift", "Swift", "Ruby", "Python", "JavaScript", "Java"]
        
        //全部削除
        languages.removeAll()
        print(languages)    
        //[]
    }
}
```

