+++
title =  "Swiftの細かい文法のメモ"
url = "2021-11-07"
date = "2021-11-07"
description = "Swiftの細かい文法のメモ"
tags = [
  "Swift"
]
categories = [
  "Swift"
]
archives = "2021/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

関数の引数は呼び出し側で省略したり、別名をつけたりすることができる。

```swift
func buyA(product: Int, price: Int, quantity: Int) {
    print(product, price, quantity)
}
buyA(product: 1200, price: 1500, quantity: 1)

func buyB(_ product: Int, _ price: Int, _ quantity: Int) {
    print(product, price, quantity)
}
buyB(123, 123, 123)

func buyC(a product: Int, b price: Int, c quantity: Int) {
    print(product, price, quantity)
}
buyC(a: 123, b: 123, c: 123)
```


関数が１行の場合は return を省略できる。

```swift
func messageA() -> String {
    return "Hello"
}

func messageB() -> String {
    "Hello"
}
```


return と同じ行に書いたコードは実行される。もちろんそれよりも下の行は実行されない。

```swift
func sayHello() {
    print("Hello")
    return print("XXX")
    print("YYY")
}

sayHello()
```

```
Hello
XXX
```


Swift で GOTO 的なことをする。

```swift
x: while true {
    y: while true {
        continue y
    }
}
```


Swift には repeat という繰返し方法がある。

```swift
var counter = 0
repeat {
    print("counter: \(counter)")
    counter = counter + 1
} while false
print("counter: \(counter)")
```

```
counter: 0
counter: 1
```
