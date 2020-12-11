+++
title =  "Xcodeでプロジェクトを作成してGithubにプッシュする"
url = "2020-12-03"
date = "2020-12-03"
description = "Xcodeでプロジェクトを作成してGithubにプッシュする"
tags = [
  "Swift"
]
categories = [
  "Swift"
]
archives = "2020/12"
aliases = ["migrate-from-jekyl"]
+++

<br>

Xcodeでプロジェクトを作成してGithubにプッシュする忘備録です。

まずプロジェクトを作成します。

![New Project](1.png)

作成したプロジェクトのフォルダを SourceTree にドラッグアンドドロップします。

![Drag and drop](2.png)

[gitignore.io](https://www.toptal.com/developers/gitignore)にアクセスして .gitignore ファイルを作成します。

![.gitignore](3.png)

新しいリポジトリを作ります。

![CreateNewRepo](4.png)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

矢印のURIをコピーします。

![Copy URI](5.png)

SourceTreeの設定からリモートリポジトリを追加します。コピーしたURIを貼り付けます。

![Add Remote Repo](6.png)

