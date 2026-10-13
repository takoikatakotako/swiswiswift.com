+++
title = "UINavigationBar"
url = "2017-05-10"
date = "2017-05-10"
description = "UINavigationBar"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS"]
archives = "2017/05"
+++

<br>

iOSアプリの画面上部によく使われているUINavigationBarについてです。

UINavigationBarのクラス階層

NSObject  
↑  
UIResponder  
↑  
UIView  
↑  
UINavigationBar  
AppleDeveloperリファレンスUINavigationBar  



UINavigationBar例文

UINavigationBarを生成し、タイトルとボタンを付けます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**UINavigationBarBasic.swift**

```swift
import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        //画面横サイズを取得
        let viewWidth = self.view.frame.width
        
        //UINavigationBarを作成
        let myNavBar = UINavigationBar()
        
        //UINavigationBarの位置とサイズを指定
        myNavBar.frame = CGRect(x: 0, y: 22, width: viewWidth, height: 40)
        
        //ナビゲーションバーの色を変える
        myNavBar.barTintColor = UIColor.gray
        
        //ナビゲーションボタンの色を変更する
        //UINavigationBar.appearance().tintColor = UIColor.black
        
        //曇りガラスの効果を消す
        myNavBar.isTranslucent = false
        
        //ナビゲーションアイテムを作成
        let myNavItems = UINavigationItem()
        myNavItems.title = "バーのタイトル"
        
        //バーの左側に設置するボタンの作成
        let leftNavBtn =  UIBarButtonItem(barButtonSystemItem:  .add, target: self, action: #selector(leftBarBtnClicked(sender:)))
        myNavItems.leftBarButtonItem = leftNavBtn
        
        //バーの右側に設置するボタンの作成
        let rightNavBtn = UIBarButtonItem()
        
        //ボタンにする画像を選択する
        let rightNavBtnImg:UIImage = UIImage(named:"swiftIcon_40")!
        rightNavBtn.image = rightNavBtnImg
        
        //ボタンが押され時のアクションを設定する
        rightNavBtn.action = #selector(rightBarBtnClicked(sender:))
        myNavItems.rightBarButtonItem = rightNavBtn;
        
        //作成したNavItemをNavBarに追加する
        myNavBar.pushItem(myNavItems, animated: true)
        self.view.addSubview(myNavBar)
    }
    
    
    //左側のボタンが押されたら呼ばれる
    internal func leftBarBtnClicked(sender: UIButton){
        print("leftBarBtnClicked")
    }
    
    //右側のボタンが押されたら呼ばれる
    internal func rightBarBtnClicked(sender: UIButton){
        print("rightBarBtnClicked")
    }

}
```

