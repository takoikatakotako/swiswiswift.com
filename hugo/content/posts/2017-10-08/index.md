+++
title = "UITableViewにヘッダーを設定する"
url = "2017-10-08"
date = "2017-10-08"
description = "UITableViewにヘッダーを設定する"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS"]
archives = "2017/10"
+++

<br>

UITableViewにヘッダーを設定するサンプルです。  
フッターも同様に設定することができます。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController,UITableViewDelegate, UITableViewDataSource {

    //テーブルビューインスタンス
    private var myTableView: UITableView!
    
    //テーブルビューに表示する配列
    private var myItems: NSArray = []
    
    override func viewDidLoad() {
        super.viewDidLoad()

    
        //テーブルビューに表示する配列
        myItems = ["りんご", "すいか", "もも", "さくらんぼ", "ぶどう", "なし","りんご", "すいか", "もも", "さくらんぼ", "ぶどう", "なし","りんご", "すいか", "もも", "さくらんぼ", "ぶどう", "なし"]
        
        //Viewの大きさを取得
        let viewWidth = self.view.frame.size.width
        let viewHeight = self.view.frame.size.height
        
        //テーブルビューの初期化
        myTableView = UITableView()
        
        //デリゲートの設定
        myTableView.delegate = self
        myTableView.dataSource = self
        
        //テーブルビューの大きさの指定
        myTableView.frame = CGRect(x: 0, y: 0, width: viewWidth, height: viewHeight)
        
        //テーブルビューの設置
        myTableView.register(UITableViewCell.self, forCellReuseIdentifier: "cell")
        self.view.addSubview(myTableView)
    
    }

    //MARK: テーブルビューのセルの数を設定する
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //テーブルビューのセルの数はmyItems配列の数とした
        return self.myItems.count
    }
    
    //MARK: テーブルビューのセルの中身を設定する
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //myItems配列の中身をテキストにして登録した
        let cell:UITableViewCell = tableView.dequeueReusableCell(withIdentifier: "cell")! as UITableViewCell
        cell.textLabel?.text = self.myItems[indexPath.row] as? String
        return cell
    }
    
    //Mark: テーブルビューのセルが押されたら呼ばれる
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("\(indexPath.row)番のセルを選択しました！ ")
    }
    
    //Mark: ヘッダーの大きさを設定する
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat{
    
        return 100
    }
    
    //Mark: ヘッダーに設定するViewを設定する
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView?{
        
        //ヘッダーにするビューを生成
        let view = UIView()
        view.frame = CGRect(x: 0, y: 0, width: self.view.frame.size.width, height: 100)
        view.backgroundColor = UIColor.red
        
        //ヘッダーに追加するラベルを生成
        let headerLabel = UILabel()
        headerLabel.frame =  CGRect(x: 0, y: 30, width: self.view.frame.size.width, height: 50)
        headerLabel.text = "ヘッダーのラベルだよ！"
        headerLabel.textColor = UIColor.white
        headerLabel.textAlignment = NSTextAlignment.center
        view.addSubview(headerLabel)
        
        return view
    }

}
```

