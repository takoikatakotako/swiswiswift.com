+++
title = "プリンター,etc（LPIC）"
url = "2022-12-11"
date = "2022-12-11"
description = "プリンター,etc（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2022/11"
aliases = ["migrate-from-jekyl"]
+++

<br>

# プリンター,etc

## Postscript Printer Description（PPD）

PPDはフォント、用紙サイズ、解像度などPostScriptプリンタの機能を記述し制御するためのファイルです。

## /etc/cups/printers.conf

登録されたプリタンタのDeviceURIが指定されている設定ファイルです。



# lpadmin

CUPSでのプリンタの登録や削除はlpadminコマンドで行うことができます。

## オプション

### -p

作成するプリンタ名を指定する。


# Ghostscript

入力されたPostScriptを解釈し、PDFやEPSなどに書き出すことができます。


# lpr

BSD系で使われる印刷コマンドです。

## サンプル

### fileをプリンタlp1で印刷する

```
$ lpr -P lp1 file
```

### fileを2部印刷する

```
$ cat file | lpr -#2
```

### フィルタを通さずにfileを印刷する

```
$ lpr -o raw file
```

```
$ lpr -l file
```


# lp

System V系で使われる印刷コマンドです。

### fileをプリンタlp1で印刷する

```
$ lp -d lp1 file
```

```
$ cat file | lp -n2
```

### フィルタを通さずにfileを印刷する

```
$ lp -o raw file
```


# lpstat

System V系で使われるプリンタのキューを表示するコマンドです。


# lpq

BSD系で使われるプリンタのキューを表示するコマンドです。


# lpc

BSD系で使われるプリンタのキューを表示するコマンドです。


# cupsdisable

指定したプリンタを停止状態にするコマンドです。

