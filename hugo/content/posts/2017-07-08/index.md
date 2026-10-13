+++
title = "delegateで別のViewからメソッドを呼び出す"
url = "2017-07-08"
date = "2017-07-08"
description = "delegateで別のViewからメソッドを呼び出す"
tags = ["iOS", "Swift"]
categories = ["iOS"]
archives = "2017/07"
+++

<br>

あるViewから他のViewControllerにある関数などを実行するデリゲートのサンプルです。  
今回はモーダル表示したViewから、元々いたViewの背景色をデリゲートを使って変えています。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**SecondViewController.swift**

```swift
import UIKit


protocol SampleDelegate: class  {
    func changeBackgroundColor(color:UIColor)
}

class SecondViewController: UIViewController {
    
    //delegate
    weak var delegate: SampleDelegate?

    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.backgroundColor = UIColor.gray
        
        //ボタンの生成
        let deleteModalBtn = UIButton()
        deleteModalBtn.frame.size = CGSize(width: 150, height: 50)
        deleteModalBtn.center.x = self.view.center.x
        deleteModalBtn.center.y = self.view.center.y
        deleteModalBtn.backgroundColor = UIColor.white
        deleteModalBtn.addTarget(self, action: #selector(deleteModalBtnClicked(sender:)), for:.touchUpInside)
        deleteModalBtn.setTitle("モーダル閉じる", for: UIControlState.normal)
        deleteModalBtn.setTitleColor(UIColor.gray, for: UIControlState.normal)
        self.view.addSubview(deleteModalBtn)

    }

    func deleteModalBtnClicked(sender: UIButton){
        
        //乱数を用いてランダムに色を作成する
        let red:Float = Float(arc4random_uniform(255))/255
        let green:Float = Float(arc4random_uniform(255))/255
        let blue:Float = Float(arc4random_uniform(255))/255
        let bgColor:UIColor = UIColor(colorLiteralRed: red, green: green, blue: blue, alpha: 1)

        //デリゲートを用いて初めのViewの色をランダムに変える
        delegate?.changeBackgroundColor(color: bgColor)
        
        //モーダルViewを閉じる
        self.dismiss(animated: true, completion: nil)
    }
}
```


**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController,SampleDelegate  {
    

    override func viewDidLoad() {
        super.viewDidLoad()
        
        //ボタンの生成
        let showModalBtn = UIButton()
        showModalBtn.frame.size = CGSize(width: 150, height: 50)
        showModalBtn.center.x = self.view.center.x
        showModalBtn.center.y = self.view.center.y
        showModalBtn.backgroundColor = UIColor.gray
        showModalBtn.addTarget(self, action: #selector(showModalBtnClicked(sender:)), for:.touchUpInside)
        showModalBtn.setTitle("モーダル表示", for: UIControlState.normal)
        showModalBtn.setTitleColor(UIColor.white, for: UIControlState.normal)
        self.view.addSubview(showModalBtn)
    }
    
    
    func showModalBtnClicked(sender: UIButton){

        //モーダルで別ビューを表示する
        let secondVC:SecondViewController = SecondViewController()
        secondVC.delegate = self
        present(secondVC, animated: true, completion: nil)
    }
    
    //Delegateで呼ぶViewの背景色を変えるメソッド
    func changeBackgroundColor(color:UIColor){
        
        self.view.backgroundColor = color
    }
}
```

