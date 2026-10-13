+++
title = "FizzBuzz(C)"
url = "2017-05-20"
date = "2017-05-20"
description = "FizzBuzz(C)"
tags = ["C"]
categories = ["C"]
archives = "2017/05"
+++

<br>

FizzBuzzをCで解きました。
いろいろな言語で FizzBuzz を作ってみると違いが出て面白いですね。


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**fizzbuzz.c**

```c
#include <stdio.h>
int main(void){

    int i;
    for(i=0;i<20;i++){
        if (i % 3 == 0 && i % 5 == 0) {
            printf("FizzBuzz\n");
        } else if (i % 3 == 0) {
            printf("Fizz\n");
        } else if (i % 5 == 0) {
            printf("Buzz\n");
        } else {
            printf("%d\n", i);
        }
    }
    return 0;
}
```

