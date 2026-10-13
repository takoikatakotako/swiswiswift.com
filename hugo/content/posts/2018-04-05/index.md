+++
title = "CustomTableViewCellとaccessoryViewを使ってTableVIewのレイアウトをカスタマイズ"
url = "2018-04-05"
date = "2018-04-05"
description = "CustomTableViewCellとaccessoryViewを使ってTableVIewのレイアウトをカスタマイズ"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS"]
archives = "2018/04"
+++

<br>

CustomTableViewCellを作ると好きなレイアウトのCellをTableViewで使うことができます。  
そしてTableViewCellのアクセサリービューにはUISwitchやチェックマークなどのアクセサリをつけることができます。  
今回はその両方を使ったサンプルコードです。  

参考にさせて頂いたウェブサイト  
[[Swift]UITableViewCellのaccessoryViewでaccessoryButtonTappedForRowWithIndexPathが来ない件の対応](https://qiita.com/seiko_m/items/03f71bea83e35d302d3f)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**CustumTableViewCell.swift**

```swift
import UIKit

class CustumTableViewCell: UITableViewCell {

    var timeLabel:UILabel!
    var alarmNameLabel:UILabel!
    var weekLabel:UILabel!
    
    override init(style: UITableViewCellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        timeLabel = UILabel()
        alarmNameLabel = UILabel()
        weekLabel = UILabel()
    }
    
    required init(coder aDecoder: NSCoder) {
        fatalError("init(coder: ) has not been implemented")
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        //let cellWidth:CGFloat = self.frame.width
        //let cellHeight:CGFloat = self.frame.height
        
        //timeLabel
        timeLabel.frame = CGRect(x: 16, y: 8, width: 200, height: 24)
        timeLabel.text = "07:00"
        timeLabel.font = UIFont.boldSystemFont(ofSize: 24)
        timeLabel.textColor = UIColor.gray
        timeLabel.textAlignment = NSTextAlignment.left
        self.addSubview(timeLabel)
        
        //timeLabel
        alarmNameLabel.frame = CGRect(x: 16, y: 36, width: 200, height: 18)
        alarmNameLabel.text = "アラーム名"
        alarmNameLabel.font = UIFont.systemFont(ofSize: 18)
        alarmNameLabel.textColor = UIColor.gray
        alarmNameLabel.textAlignment = NSTextAlignment.left
        self.addSubview(alarmNameLabel)
        
        
        //timeLabel
        weekLabel.frame = CGRect(x: 16, y: 56, width: 200, height: 18)
        weekLabel.text = "毎日"
        weekLabel.font = UIFont.systemFont(ofSize: 18)
        weekLabel.textColor = UIColor.gray
        weekLabel.textAlignment = NSTextAlignment.left
        self.addSubview(weekLabel)
        
    }
}
```


**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController,UITableViewDelegate, UITableViewDataSource  {
    
    //テーブルビューインスタンス
    private var myTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //テーブルビューの初期化
        myTableView = UITableView()
        
        //デリゲートの設定
        myTableView.delegate = self
        myTableView.dataSource = self
        
        //テーブルビューの大きさの指定
        myTableView.frame = view.frame
        
        //テーブルビューの設置
        myTableView.register(CustumTableViewCell.self, forCellReuseIdentifier: NSStringFromClass(CustumTableViewCell.self))
        myTableView.rowHeight = 80
        self.view.addSubview(myTableView)
    }
    
    //MARK: テーブルビューのセルの数を設定する
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //テーブルビューのセルの数は10とした
        return 10
    }
    
    //MARK: テーブルビューのセルの中身を設定する
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //myItems配列の中身をテキストにして登録した
        let cell:UITableViewCell = tableView.dequeueReusableCell(withIdentifier: NSStringFromClass(CustumTableViewCell.self))! as! CustumTableViewCell
        
        //以下の行を追加するとセル選択時にハイライトしなくなる
        cell.selectionStyle = .none
        
        //cellのアクセサリービューに追加する
        if cell.accessoryView == nil{
            let switchView = UISwitch()
            switchView.isOn = false
            switchView.tag = indexPath.row
            switchView.addTarget(self, action: #selector(switchTriggered), for: .valueChanged)
            cell.accessoryView = switchView
        }
        return cell
    }
    
    //Mark: テーブルビューのセルが押されたら呼ばれる
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("\(indexPath.row)番のセルを選択しました！ ")
    }
    
    //cellのアクセサリービューに追加したUISwitchが変化すると呼ばれる
    @objc func switchTriggered(sender: UISwitch){
        print(sender.tag)
        print(sender.isOn)
    }
}
```

