+++
title = "UICollectionViewにCustomセルを追加する"
url = "2017-10-03"
date = "2017-10-03"
description = "UICollectionViewにCustomセルを追加する"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS"]
archives = "2017/10"
+++

<br>

UICollectionViewにCustumCollectionセルを追加してみました。  

クラス名を文字列に変換する `NSStringFromClass(CustumCollectionViewCell.self)` は、`UITableViewやUICollectionView` を使うときにとても便利です。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**CustumCollectionViewCell.swift**

```swift
import UIKit

class CustumCollectionViewCell: UICollectionViewCell {
    
    var textLabel : UILabel?
    
    required init(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)!
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        // UILabelを生成.
        textLabel = UILabel(frame: CGRect(x:0, y:0, width:frame.width, height:frame.height))
        textLabel?.text = "nil"
        textLabel?.backgroundColor = UIColor.white
        textLabel?.textAlignment = NSTextAlignment.center
        
        // Cellに追加.
        self.contentView.addSubview(textLabel!)
    }
}
```


**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource {
    
    var myCollectionView : UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let viewWidth = self.view.frame.width
        let viewHeight = self.view.frame.height
        let collectionFrame = CGRect(x: 0, y: 0, width: viewWidth, height: viewHeight)
        
        // CollectionViewのレイアウトを生成.
        let layout = UICollectionViewFlowLayout()
        
        // Cell一つ一つの大きさ.
        layout.itemSize = CGSize(width:viewWidth/4, height:viewWidth/4)
        
        // セルのマージン.
        layout.sectionInset = UIEdgeInsets.zero
        //layout.sectionInset = UIEdgeInsetsMake(16, 16, 16, 16)

        //セルの横方向のマージン
        layout.minimumInteritemSpacing = 0.0
        
        //セルの縦方向のマージン
        layout.minimumLineSpacing = 0.0
        
        // セクション毎のヘッダーサイズ.
        layout.headerReferenceSize = CGSize(width:0,height:0)
        
        // CollectionViewを生成.
        myCollectionView = UICollectionView(frame: collectionFrame, collectionViewLayout: layout)
        
        // Cellに使われるクラスを登録.
        myCollectionView.register(CustumCollectionViewCell.self, forCellWithReuseIdentifier: NSStringFromClass(CustumCollectionViewCell.self))
        
        myCollectionView.delegate = self
        myCollectionView.dataSource = self
        
        self.view.addSubview(myCollectionView)
    }
    
    //Cellが選択された際に呼び出される
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        
        print("Num: \(indexPath.row)")
    }
    
    //Cellの総数を返す
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 100
    }
    
    //Cellに値を設定する
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell : CustumCollectionViewCell = collectionView.dequeueReusableCell(withReuseIdentifier: NSStringFromClass(CustumCollectionViewCell.self), for: indexPath) as! CustumCollectionViewCell
        cell.textLabel?.textColor = UIColor.white
        cell.textLabel?.backgroundColor = makeColor()
        cell.textLabel?.text = indexPath.row.description

        return cell
    }
    
    //ランダムに色を生成する
    func makeColor() -> UIColor {
        let r: CGFloat = CGFloat(arc4random_uniform(255)+1) / 255.0
        let g: CGFloat = CGFloat(arc4random_uniform(255)+1) / 255.0
        let b: CGFloat = CGFloat(arc4random_uniform(255)+1) / 255.0
        let color: UIColor = UIColor(red: r, green: g, blue: b, alpha: 1.0)
        
        return color
    }
}
```

