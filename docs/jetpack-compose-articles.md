# Jetpack Composeの素材と記事の対応

`Desktop/JetpackCompose`の13フォルダーを既存記事と照合した。既存のCompose記事は`2021-05-11`の基本的な画面遷移で、今回の各サンプルと同一の記事はなかった。同じ日付の既存記事はSwiftUIのため、日付にComposeの名前を付けた別のURLで追加した。日付は素材のフォルダー名を保持している。

| 素材フォルダー | 記事 | 補足 |
| --- | --- | --- |
| 2023-10-01 | [Jetpack Composeで画像全体が収まるように表示する（ContentScale.Fit）](../hugo/content/posts/2023-10-01-jetpack-compose-image-fit/index.md) |  |
| 2023-10-02 | [Jetpack Composeで画像を領域いっぱいに表示する（ContentScale.Crop）](../hugo/content/posts/2023-10-02-jetpack-compose-image-crop/index.md) |  |
| 2023-10-03 | [Jetpack Composeで画像を丸く切り取る](../hugo/content/posts/2023-10-03-jetpack-compose-circle-image/index.md) |  |
| 2023-10-04 | [Jetpack Composeで丸い画像に枠を付ける](../hugo/content/posts/2023-10-04-jetpack-compose-circle-image-border/index.md) |  |
| 2023-10-05 | [Jetpack Composeで画像を等間隔で横に並べる](../hugo/content/posts/2023-10-05-jetpack-compose-row-spacing/index.md) |  |
| 2023-10-06 | [Jetpack ComposeのNavigationBarで画面を切り替える](../hugo/content/posts/2023-10-06-jetpack-compose-bottom-navigation/index.md) | 空のRoute.ktを補完。選択状態を画面遷移に連動。 |
| 2023-10-07 | [Jetpack ComposeでTopAppBarにタイトルを表示する](../hugo/content/posts/2023-10-07-jetpack-compose-top-app-bar/index.md) |  |
| 2023-10-08 | [Jetpack Composeでボタンを押したら文字を変える](../hugo/content/posts/2023-10-08-jetpack-compose-button-state/index.md) |  |
| 2023-10-09 | [Jetpack ComposeのLazyColumnでリストを表示する](../hugo/content/posts/2023-10-09-jetpack-compose-lazy-column/index.md) | 空のContentView.ktを録画と10日のリストから補完。 |
| 2023-10-10 | [Jetpack Composeでリストから画面遷移して値を渡す](../hugo/content/posts/2023-10-10-jetpack-compose-navigation-argument/index.md) | 文字列の引数をUri.encode。 |
| 2023-10-11 | [Jetpack ComposeでAlertDialogを表示する](../hugo/content/posts/2023-10-11-jetpack-compose-alert-dialog/index.md) |  |
| 2023-10-12 | [Jetpack ComposeでボタンごとにAlertDialogを出し分ける](../hugo/content/posts/2023-10-12-jetpack-compose-multiple-dialogs/index.md) |  |
| 2026-01-01 | [Jetpack Composeでリストの項目を開いて自動スクロールする](../hugo/content/posts/2026-01-01-jetpack-compose-expandable-list/index.md) | 元プロジェクトのPokemonCardを参照し、1項目ずつ開く簡略版に整理。説明文をサンプル用に短縮。 |

画像・動画は元ファイルをそのままコピーし、記事内の横幅のみ300pxに指定。動画のposterは元動画の0.5秒地点から抽出した。Desktopの素材は削除・変更していない。

## 検証

- Hugo 0.167.0でproductionビルドを実行し、13本のURL・サイトマップ・記事内リンクを確認。
- 全アセットについて元ファイル・記事バンドル・生成先のSHA-256が一致することを確認。
- 記事のKotlinコードブロックとダウンロード用の.ktが一致することを確認。
- 元のSwiSwiKotlinプロジェクトを一時ディレクトリにコピーし、13本のソースをクラス・関数名の衝突を避けて配置。`./gradlew --no-daemon :app:compileDebugKotlin`が成功。AGP 8.5.0、Kotlin 1.9.0、Compose BOM 2024.04.01、Navigation Compose 2.7.7を使用し、インストール済みSDKに合わせてcompileSdkは35とした。
- 元動画7本を最後までデコードし、Chromeでもリスト動画の再生を確認。画像記事とタグ一覧をローカルで確認。

Kotlinの確認はコンパイルまで。新しいコードを端末やエミュレーターで実行した検証ではない。記事の画像・動画は保存されていた元サンプルのもの。
