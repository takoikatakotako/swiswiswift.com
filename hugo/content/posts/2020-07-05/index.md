+++
title =  "UIPickerViewを使って値を選択する"
url = "2020-07-05"
date = "2020-07-05"
description = "UIPickerViewを使って値を選択する"
tags = ["iOS", "Swift", "UIKit"]
categories = ["iOS", "Swift"]
archives = "2020/07"
+++

<br>

UIPickerViewを使って値を取得するサンプルコードです。
PIPickerViewは選択肢の中から要素を選ぶときによく使いますね。
今回は食べ物とドリンクとフードを選ぶアプリを作ってみました。

![Picker](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ViewController.swift**

```swift
import UIKit

class ViewController: UIViewController {
    // UIPickerView.
    private lazy var myUIPicker = UIPickerView()
    
    // Value
    private let foodMenus: [String]  = ["Hamburger","Pizza","Steak","Meatpai"]
    private let drinkMenus: [String]  = ["Coke","Water","Orange juice","Tomato Juice", "Coffee"]
    private let dessertMenus: [String] = ["Ice Cream","Chocolate","Candy","LolliPop", "Donuts", ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // make UIPickerView instance
        myUIPicker = UIPickerView()
        
        // set picker size
        myUIPicker.frame = CGRect(x: 0, y: 0, width: view.bounds.width, height: view.bounds.height)
        
        // set delegate
        myUIPicker.delegate = self
        
        // set datasources
        myUIPicker.dataSource = self
        
        // Set init picker position
        myUIPicker.selectRow(1, inComponent: 0, animated: true)
        myUIPicker.selectRow(2, inComponent: 1, animated: true)
        myUIPicker.selectRow(3, inComponent: 2, animated: true)

        // add view
        view.addSubview(myUIPicker)
    }
}


extension ViewController: UIPickerViewDelegate {
    // Called when picker moved
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        print("componet: \(component)")
        print("row: \(row)")
        
        switch component {
        case 0:
            print("value: \(foodMenus[row])")
        case 1:
            print("value: \(drinkMenus[row])")
        case 2:
            print("value: \(dessertMenus[row])")
        default:
            print("Error")
        }
    }
}

extension ViewController: UIPickerViewDataSource {
    // Set number of Compenet
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        // foodMenus + drinkMenus + dessertMenus
        return 3
    }
    
    // Set the number of elements of Compenet
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        
        switch component {
        case 0:
            return foodMenus.count
        case 1:
            return drinkMenus.count
        case 2:
            return dessertMenus.count
        default:
            return 0
        }
    }
    
    // Set elements String
    /*
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        switch component {
        case 0:
            return foodMenus[row]
        case 1:
            return drinkMenus[row]
        case 2:
            return dessertMenus[row]
        default:
            return "Error"
        }
    }
    */
    
    // Set elements UIView
    func pickerView(_ pickerView: UIPickerView, viewForRow row: Int, forComponent component: Int, reusing view: UIView?) -> UIView {
        
        let cellLabel = UILabel()
        cellLabel.frame = CGRect(x: 0, y: 0, width: pickerView.rowSize(forComponent: 0).width, height: pickerView.rowSize(forComponent: 0).height)
        cellLabel.textAlignment = .center
        cellLabel.font = UIFont.boldSystemFont(ofSize: 16)
        cellLabel.backgroundColor = UIColor.orange
        cellLabel.textColor = UIColor.white
        
        switch component {
        case 0:
            cellLabel.text = foodMenus[row]
        case 1:
            cellLabel.text = drinkMenus[row]
        case 2:
            cellLabel.text =  dessertMenus[row]
        default:
            cellLabel.text = "Error"
        }
        
        return cellLabel
    }
}
```

