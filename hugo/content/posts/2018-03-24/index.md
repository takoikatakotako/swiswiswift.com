+++
title = "Google Cloud FunctionでHelloWorld"
url = "2018-03-24"
date = "2018-03-24"
description = "Google Cloud FunctionでHelloWorld"
tags = ["GCP"]
categories = ["GCP"]
archives = "2018/03"
+++

<br>

Google様のCloud Functionを触ってみたので、そのメモです。  
HelloWorldとJsonでの出力とgetの受け取りです。  

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**index.js**

```javascript
const functions = require('firebase-functions');

 exports.helloWorld = functions.https.onRequest((request, response) => {
  response.send("Hello from Firebase!");
 });

 exports.json = functions.https.onRequest((request, response) => {

   const json = {
       id: "Hello",
       contributions: "contributions",
   };
   response.send(JSON.stringify(json));
 });

 exports.goodEvening = functions.https.onRequest((request, response) => {
   var str_out = ""
   const user = request.query.user
   str_out += "user = " + user
   response.send(str_out)
 });
```

