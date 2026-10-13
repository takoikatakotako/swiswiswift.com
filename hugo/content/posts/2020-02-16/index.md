+++
title =  "SwiftでCSVを集計する"
url = "2020-02-16"
date = "2020-02-16"
description = "SwiftでCSVを集計する"
tags = ["Swift"]
categories = ["Swift"]
archives = "2020/02"
+++

<br>

Swift で CSV を集計する方法です。
まず前処理として、CSV ファイルを utf8 に変換する必要があります。
Mac の場合は Numbers で開き、CSV で保存すると上手く行きました。

```
$ swift main.swift
```

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**main.swift**

```swift
import Foundation

struct Questionnaire {
    let participantName: String         // 参加枠名
    let userName: String                // ユーザー名
    let displayName: String             // 表示名
    let comment: String                 // コメント
    let startDate: String               // 利用開始日
    let participationStatus: String     // 参加ステータス
    let attendanceStatus: String        // 出欠ステータス
    let swiftWriteYear: String          // Swiftを書き始めてどのくらいですか？
    let participatedTrySwift: String    // try! Swift Tokyoには参加したことがありますか？また、try! Swift Tokyo2020には参加予定ですか？
    let participationReason : String    // 今回のMeetup参加の理由があればお聞かせください
    let talkTime: String                // 【登壇枠の方】希望のトーク時間はどちらですか？
    let attendanceParty: String         // 懇親会への参加可否を教えてください。
}

// イベント管理 -> 申込者の管理 -> CSVダウンロード
// 文字形式が urf8 ではないので、一度 numbers で開いて urf8 で保存する
let filePath = FileManager.default.currentDirectoryPath + "/" + "event_160481_participants.csv"

guard let csvString = try? String(contentsOfFile: filePath, encoding: String.Encoding.utf8) else {
    fatalError("CSVファイルを読み込めませんでした")
}
let csvLines = csvString.components(separatedBy: .newlines)
var questionnaires: [Questionnaire] = []

csvLines.filter {
    !$0.isEmpty
}.forEach {
    let elements = $0.components(separatedBy: ",")
    let questionnaire = Questionnaire(
        participantName: elements[0],
        userName: elements[1],
        displayName: elements[2],
        comment: elements[3],
        startDate: elements[4],
        participationStatus: elements[5],
        attendanceStatus: elements[6],
        swiftWriteYear: elements[7],
        participatedTrySwift: elements[8],
        participationReason: elements[9],
        talkTime: elements[10],
        attendanceParty: elements[11])
    questionnaires.append(questionnaire)
}

print("------------")
print("参加人数: \(questionnaires.filter({$0.participationStatus == "参加"}).count)")
print("補欠人数: \(questionnaires.filter({$0.participationStatus == "補欠"}).count)")
print("参加キャンセル: \(questionnaires.filter({$0.participationStatus == "参加キャンセル"}).count)")

print("------------")
print("Swift歴")
print("～1年: \(questionnaires.filter({$0.swiftWriteYear == "～1年"}).count)")
print("1年～2年: \(questionnaires.filter({$0.swiftWriteYear == "1年～2年"}).count)")
print("3年以上: \(questionnaires.filter({$0.swiftWriteYear == "3年以上"}).count)")

print("------------")
print("trySwift参加する?")
print("今まで参加したことがなく、今年も参加を迷っている: \(questionnaires.filter({$0.participatedTrySwift == "今まで参加したことがなく、今年も参加を迷っている"}).count)")
print("今まで参加したことがなく、今年は参加予定だ: \(questionnaires.filter({$0.participatedTrySwift == "今まで参加したことがなく、今年は参加予定だ"}).count)")
print("今まで参加したことがあり、今年は参加を迷っている: \(questionnaires.filter({$0.participatedTrySwift == "今まで参加したことがあり、今年は参加を迷っている"}).count)")
print("今まで参加したことがあり、今年も参加予定だ: \(questionnaires.filter({$0.participatedTrySwift == "今まで参加したことがあり、今年も参加予定だ"}).count)")

print("------------")
print("懇親会どうする？")
print("不参加予定: \(questionnaires.filter({$0.attendanceParty == "不参加予定"}).count)")
print("参加予定: \(questionnaires.filter({$0.attendanceParty == "参加予定（成人しており、お酒を飲むことになっても問題ありません。）"}).count)")
print("参加 && 懇親会参加予定: \(questionnaires.filter({$0.participationStatus == "参加" &&  $0.attendanceParty == "参加予定（成人しており、お酒を飲むことになっても問題ありません。）"}).count)")
print("------------")
print("コメント")
questionnaires.filter({
    !($0.participationReason.isEmpty)
}).forEach {
    print("\($0.participationReason)")
}
```

