+++
title = "Array(Swift4.2)"
url = "2019-01-01"
date = "2019-01-01"
description = "Array(Swift4.2)"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2019/01"
+++

<br>

#Swift4.2  
Swiftの配列です。配列の作成と呼び出しについて記載します。

#Swift3の記事はこちら  
Array

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Array.swift**

```swift
// 配列の宣言, 空配列を作成
var languages = [String]()
let languages2: [String] = []
let languages3: Array<String> = []

// 代入
languages = ["Ruby","C","Swift","Python","Swift"]

// 繰り返しで出力
for language in languages {
    print("\(language) ")
    // Ruby
    // C
    // Swift
    // Python
    // Swift
}

// インデックス付きで繰り返しで出力
for (index, language) in languages.enumerated() {
    print(index, language)
    // 0 Ruby
    // 1 C
    // 2 Swift
    // 3 Python
    // 4 Swift
}

// 二番目の要素にアクセス->C
print("二番目の要素にアクセス->\(languages[1]) ")

// 一番最後の要素にアクセス
print("一番最後の要素にアクセス->\(languages.last!) ")
// 一番最後の要素にアクセス->Swift

// 要素数を数える
print("languages配列の要素数は？->\(languages.count) ")
// languages配列の要素数は？->5

//配列の中にある要素が含まれているのかを調べる
let isContein:Bool = languages.contains("Python")
print("Pythonはlanguagesに含まれている？->\(isContein)")
// Pythonはlanguagesに含まれている？->true

// 要素を配列の最後に追加
languages.append("Lisp")
print(languages)
// ["Ruby", "C", "Swift", "Python", "Swift", "Lisp"]

// 配列に要素を追加、先頭に挿入
languages.insert("Java", at: 0)
print(languages)
// ["Java", "Ruby", "C", "Swift", "Python", "Swift", "Lisp"]

//配列に要素を追加、2番目に挿入
languages.insert("JavaScript", at: 2)
print(languages)
// ["Java", "Ruby", "JavaScript", "C", "Swift", "Python", "Swift", "lisp"]

//配列の反転
languages = languages.reversed()
print(languages)
// ["Lisp", "Swift", "Python", "Swift", "C", "JavaScript", "Ruby", "Java"]

//ソート処理：降順
languages = languages.sorted{ $0 < $1 };
print(languages)
// ["C", "Java", "JavaScript", "Lisp", "Python", "Ruby", "Swift", "Swift"]

//ソート処理：昇順
languages = languages.sorted{ $1 < $0 }
print(languages)
// ["Swift", "Swift", "Ruby", "Python", "Lisp", "JavaScript", "Java", "C"]

//フィルタ（最初の文字が*の場合。以下はJの場合）
let filteredLanguages = languages.filter {$0.hasPrefix("J")}
print(filteredLanguages)
// ["JavaScript", "Java"]

// 一番目の要素を削除
print(languages)
// ["Swift", "Swift", "Ruby", "Python", "Lisp", "JavaScript", "Java", "C"]
languages.remove(at: 0)
print(languages)
// ["Swift", "Ruby", "Python", "Lisp", "JavaScript", "Java", "C"]

// 最後の要素を削除
print(languages)
// ["Swift", "Ruby", "Python", "Lisp", "JavaScript", "Java", "C"]
languages.removeLast()
print(languages)
// ["Swift", "Ruby", "Python", "Lisp", "JavaScript", "Java"]

// 全部削除
languages.removeAll()
print(languages)
// []
```

