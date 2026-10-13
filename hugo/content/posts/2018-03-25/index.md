+++
title = "Arduinoでボタンを使う(プルアップ抵抗無し)"
url = "2018-03-25"
date = "2018-03-25"
description = "Arduinoでボタンを使う(プルアップ抵抗無し)"
tags = ["Arduino"]
categories = ["Arduino"]
archives = "2018/03"
+++

<br>

Arduinoでボタンを使うときのサンプルコードです。  
あんまり知られていないんですが、プルアップを使うとプルアップ抵抗が無しで簡単にボタンを使うことができるんですよ。  
グラウンドとDegitalの2番ポートを繋げると(ボタンを押すと)そのことを認識できます。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ButtonTest.ino**

```cpp
const int buttonPin = 2;
 
void setup() {
  Serial.begin(9600);
  pinMode(buttonPin, INPUT_PULLUP);     
}
 
void loop(){
  //ボタンが押されているとbuttonPinがGNDに落ちるのでLOWになる
  if (digitalRead(buttonPin) == LOW) {
      Serial.println("PushPush");
  } else {
      Serial.println("Not Push");
  }

  delay(1000);
}
```

