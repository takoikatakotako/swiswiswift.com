+++
title = "BIOSとUEFI（LPIC）"
url = "2022-11-12"
date = "2022-11-12"
description = "BIOSとUEFI（LPIC）"
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

# BIOSとUEFI

BIOS、UEFIはマザーボードに搭載されているプログラムです。
UEFIはBIOSの後継で、直感的なインターフェイス（マウスでも操作可能）、ハードディスクの容量が2.2TBを超えても対応可能、ネットワーク機能などがあります。


## BIOS

BIOS -> MBR -> ブートローダー -> Kernel -> OS


## UEFI

UEFI -> GPT, EFIブートローダー -> Kernel -> OS

