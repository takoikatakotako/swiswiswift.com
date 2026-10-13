+++
title = "Java で文字列をシャッフルする"
url = "2019-03-15"
date = "2019-03-15"
description = "Java で文字列をシャッフルする"
tags = ["Java"]
categories = ["Java"]
archives = "2019/03"
+++

<br>

Java での文字列のシャッフル方法です。  
結構面倒だったので、記事にしました。
`.suffld` みたいなのが欲しいです。

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**Main.java**

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static public void main(String[] args) {
        String str = "I like Snorlax!!!";

        // shuffle 1
        System.out.println("shuffle1: " + shuffle1(str));

        // shuffle 2
        System.out.println("shuffle2: " + shuffle2(str));
    }

    static private String shuffle1(String str) {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        Collections.shuffle(chars);

        StringBuilder builder = new StringBuilder(chars.size());
        for(Character ch: chars) {
            builder.append(ch);
        }
        return builder.toString();
    }

    static private String shuffle2(String str) {
        final List<String> singles = Arrays.asList(str.split(""));
        Collections.shuffle(singles);
        return singles.stream().reduce((s1, s2) -> s1 + s2).get();
    }
}
```

