+++
title = "ESP32でSDカードのテキストファイルを読み書きする。"
url = "2017-10-01"
date = "2017-10-01"
description = "ESP32でSDカードのテキストファイルを読み書きする。"
tags = ["ESP32"]
categories = ["ESP32"]
archives = "2017/10"
+++

<br>

ESP32でSDカードに保存されたテキストファイルを読み書きするサンプルです。  
読み込んで書き込むシンプルなサンプルコードがネットにあまりな無かったので描いてみました。  

SDカードとESPとの配線はこちらのサイトを参考にしました。  
[mgo-tec電子工作](https://www.mgo-tec.com/blog-entry-esp32-wroom-micro-sdhc-01.html)  
いろいろ調べたのですが、プルアップ抵抗はあった方が良いっぽいです。
そして、 [mgo-tec電子工作](https://www.mgo-tec.com/blog-entry-esp32-wroom-micro-sdhc-01.html) にはいつもお世話になっています、ありがとうございます。  

そしてこちらのコードを参考にさせていただきました。  
ArduinoでSDカードにデータを保存する  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**sd.ino**

```cpp
#include <SD.h>
#define LOG_FILE_NAME "/log.txt"

const uint8_t SD_CS = 5; // GPIO5=CS
static File s_myFile;

void SD_init()
{
    Serial.print("Initializing SD card...");

    if (!SD.begin(SD_CS)) {
      Serial.println("initialization failed!");
      return;
    }
    Serial.println("initialization done.");        
}

String SD_read() {

    String str;
    File file = SD.open(LOG_FILE_NAME, FILE_READ);

    if(file){
        //---1byteずつ読み込んだ文字を結合
        while (file.available()) {
            str += char(file.read());
        }
    } else{
        Serial.println(" error...");
    }
    //---ファイルを閉じる
    file.close();
    
    return str;
}

void SD_write()
{
    String backLog = SD_read();

    s_myFile = SD.open(LOG_FILE_NAME, FILE_WRITE);
    if (s_myFile) {
        Serial.print("Writing to test.txt...");
        s_myFile.print(backLog);
        s_myFile.println("Hello, World");
        s_myFile.close();
        Serial.println("done.");
    } else {
        Serial.println("error opening test.txt");
    }
}

void setup() {
    Serial.begin(115200);
    while(!Serial);
    Serial.println();
    SD_init();
    SD_write();
    Serial.println(SD_read());
}

void loop() {
  // put your main code here, to run repeatedly:
}
```

