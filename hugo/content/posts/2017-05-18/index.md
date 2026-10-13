+++
title = "Webテスト用のカンペ(Ruby)"
url = "2017-05-18"
date = "2017-05-18"
description = "Webテスト用のカンペ(Ruby)"
tags = ["Ruby"]
categories = ["Ruby"]
archives = "2017/05"
+++

<br>

Webテスト用のカンペです。
就活してるとWebテストで競技プログラミングがよく出てくるので、まとめてみました。


<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**ruby_kanpe.rb**

```ruby
#出力
print 'hello (print)' # 改行なしで出力
puts 'hello(put)' # 改行ありで出力
p 'hello(p)' # デバッグ用出力（データ形式がわかる）


#繰り返し
for num in 1..3 do
  puts(num)
end


#if文
if false then
  puts ('if Line')
elsif 3>2 then
  puts ('elsif')
else
  puts ('else')
end


#文字列比較
if 'hello'.eql?("hello")
  puts ('hello = hello')   
end


#関数
def double(num)

  return num*2
end
puts double(3)


#ファイル
if __FILE__ == $0

end


#文字列の分割
#=> ["apple", "big", "dog"]
split_ary =  'apple big dog'.split
puts split_ary

split_ary2 =  'alpha,bbq,cat'.split(",")
puts split_ary2


#文字列の末尾の改行文字を取り除く
puts "dogs\n".chomp


#文字列を数字に変換
puts "12.3".to_i #=> 12
puts "12.3".to_f #=> 12.3


#数列の配列を生成
#=> [2,3,4]
num_ary = (2..4).to_a
puts num_ary
```

