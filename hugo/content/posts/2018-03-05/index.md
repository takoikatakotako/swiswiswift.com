+++
title = "UIAlertControllerで下からニュッと出す(UIActionSheet)"
url = "2018-03-05"
date = "2018-03-05"
description = "UIAlertControllerで下からニュッと出す(UIActionSheet)"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS"]
archives = "2018/03"
+++

<br>

下からニュッと出てくるアラートはUIAlertControllerを用いて実装します。  
遥か昔、下からニュッと出てくるアラートはUIActionSheetなんて呼ばれている時期もありましたが、UIAlertControllerに統合されました。  

![alt](1.gif)

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
        
        let viewWidth = self.view.frame.width
        let viewHeight = self.view.frame.height
        
        //アラート表示用のボタンを用意する
        let basicButton = UIButton()
        basicButton.frame = CGRect(x: viewWidth*0.1, y: viewHeight*0.45, width: viewWidth*0.8, height: viewHeight*0.1)
        basicButton.backgroundColor = UIColor.orange
        basicButton.setTitle("押すとアラートが出るよ", for: UIControlState.normal)
        basicButton.setTitleColor(UIColor.white, for: UIControlState.normal)
        basicButton.addTarget(self, action: #selector(showAlert(sender:)), for:.touchUpInside)
        self.view.addSubview(basicButton)
    }
    
    //ボタンが押されるとこの関数が呼ばれる
    @objc func showAlert(sender: UIButton){
        
        //UIAlertControllerを用意する
        let actionAlert = UIAlertController(title: "ポケモンリスト", message: "好きなポケモンを選んでください。", preferredStyle: UIAlertControllerStyle.actionSheet)
        
        //UIAlertControllerにカビゴンのアクションを追加する
        let kabigonAction = UIAlertAction(title: "カビゴン", style: UIAlertActionStyle.default, handler: {
            (action: UIAlertAction!) in
            print("カビゴンのシートが選択されました。")
        })
        actionAlert.addAction(kabigonAction)
        
        //UIAlertControllerにピカチュウのアクションを追加する
        let pikachuAction = UIAlertAction(title: "ピカチュウ", style: UIAlertActionStyle.default, handler: {
            (action: UIAlertAction!) in
            print("ピカチュウのシートが選択されました。")
        })
        actionAlert.addAction(pikachuAction)
        
        //UIAlertControllerにキャンセルのアクションを追加する
        let cancelAction = UIAlertAction(title: "キャンセル", style: UIAlertActionStyle.cancel, handler: {
            (action: UIAlertAction!) in
            print("キャンセルのシートが押されました。")
        })
        actionAlert.addAction(cancelAction)
        
        //アクションを表示する
        self.present(actionAlert, animated: true, completion: nil)
        
    }
}
```

