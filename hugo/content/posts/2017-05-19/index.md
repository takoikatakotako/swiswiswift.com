+++
title = "FizzBuzz(Ruby)"
url = "2017-05-19"
date = "2017-05-19"
description = "FizzBuzz(Ruby)"
tags = ["Ruby"]
categories = ["Ruby"]
archives = "2017/05"
+++

<br>

FizzBuzzをRubyで解いてみました。
いろいろな言語で FizzBuzz を作ってみると違いが出て面白いですね。


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**fizzbuzz.rb**

```ruby
for num in 1..20 do

  if num%3 == 0 && num%5 == 0 then
    puts('Fizz Buzz')
  elsif num%3 == 0 then
    puts('Fizz')
  elsif num%5 == 0
    puts('Buzz')
  else
    puts(num)
  end
end
```

