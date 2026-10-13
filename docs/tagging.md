# タグの付け方

## 基本ルール

- 記事の主題となる言語・フレームワーク・サービス・プラットフォームをタグにします。
- 表記は以下の一覧に合わせます。同じ技術をバージョン別に分割せず、`Swift5` などは `Swift` に揃えます。バージョンは記事タイトル・本文に記載します。
- 同じタグを複数回付けず、タグ配列は大文字小文字を区別しない名前順に並べます。
- 言語とフレームワークは別のタグです。Swiftのコード例には `Swift`、SwiftUIの実装には `Swift` と `SwiftUI` を付けます。
- UIKitが主題の記事には `UIKit` と `iOS` を付けます。SwiftUIは複数のプラットフォームに対応するため、一律に `iOS` を付けません。
- LPIC学習の記事には `Linux` と `LPIC` を付けます。
- Bashのスクリプトには `Bash` と `Shell` を付けます。`Shell` はBash以外のシェルも含む分類です。
- 記事一覧などのインデックスページには記事のタグを付けません。

カテゴリはタグとは別に記事を分類するためのものです。名前の表記はタグと揃えますが、記事のタグ配列とカテゴリ配列を同じにする必要はありません。

## 使用する表記

| 種類 | タグ |
| --- | --- |
| 言語・記法 | Bash, C, C++, Elm, Go, HTML5, Java, JavaScript, PHP, Python, Ruby, Rust, Swift, TeX |
| フレームワーク | Jetpack Compose, Rails, React Native, Spring, SwiftUI, UIKit |
| OS・環境 | Android, CentOS, iOS, Linux, macOS, Shell, Terminal |
| クラウド・サービス | App Store Connect, AWS, Firebase, GCP, IIJ |
| 開発ツール・データベース | Docker, FFmpeg, find, Gradle, Hugo, Igor, IntelliJ, MySQL, Terraform, Xcode |
| 電子工作 | Arduino, ESP32, PCBE, 電子工作 |
| 学習・イベント | AtCoder, iOSDC, LPIC, カンファレンス |
| その他 | キャリア, 今年の目標, 就活, その他 |

表示名は `hugo/content/tags/<slug>/_index.md` の `title` で管理します。Hugoによる自動的な大文字化で `iOS` が `IOS`、`iOSDC` が `IOSDC` になることを防ぎます。カテゴリの表示名も同様に `hugo/content/categories/` で管理します。

新しいタグを追加するときは、同じ意味の既存タグがないか確認し、この一覧と表示名のファイルにも追加します。

## 今回の統一

| 以前の表記 | 統一後 |
| --- | --- |
| Golang | Go |
| ReactNative | React Native |
| Swift5 | Swift |
| bash | Bash |
| Tex | TeX |
| Mac | macOS |
| Other | その他 |

大文字小文字のみを変えたタグのURLは同じです。それ以外は旧URLから統一後のタグページへの転送を残しています。`/tags/index/` は `/posts/` へ転送します。

703記事を確認し、次のような誤分類・不足も修正しました。

- Rubyの配列記事が `iOS`、UbuntuのDocker記事が `iOS`、macOS操作・App Store Connectの記事が `Golang`、AWS CLI・EC2の記事が `JavaScript` になっていた誤分類。
- Swiftのデコード、UIKit、Xcodeの操作記事に付いていた `SwiftUI` の誤分類。
- 本文のコードやタイトルで確認できる `Swift`, `SwiftUI`, `UIKit`, `LPIC`, `Bash` などのタグ不足。
- Springのお問い合わせフォーム連載の一部だけに `Spring` と `Java` がなかった不統一。
- `Swift` や `AtCoder` の重複。

記事の本文・コード・画像・URLは変更していません。
