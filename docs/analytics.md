# Google Analytics 4

ブログ管理用のGoogleアカウントにある既存のプロパティ・ウェブストリームを使用します。操作前にアカウントメニューで管理用アカウントを選び、プロパティ名とストリームURLを確認してください。

| 設定 | 値 |
| --- | --- |
| アナリティクスアカウント | Snorlax（82467612） |
| プロパティ | swiswiswift.com - GA4（325099342） |
| ウェブストリーム | swiswiswift.com - GA4（3865699656） |
| ストリームURL | https://swiswiswift.com |
| 測定ID | G-BHT15MJHCR |

測定IDは `hugo/hugo.toml` の `services.googleAnalytics.id` で管理します。公開HTMLに含まれる識別子で、API secretや認証情報ではありません。

## タグの出力

テーマのheadでHugo標準の `google_analytics.html` partialを1回呼び出します。`hugo.IsProduction` がtrueで、`hugo.IsServer` がfalseの場合だけ出力します。

- `make build`、mainのデプロイCI: 本番向けHTMLにタグを出力。
- `make run`、`hugo server`: タグを出力しない。
- `hugo -s hugo --environment development`: タグを出力しない。

CIのビルドやHTML検査だけでは計測リクエストは送信されません。CIでブラウザを使う検証を追加する場合は、development環境のビルドを使用してください。本番ビルドをローカルの静的サーバーで開くと計測タグが実行されるため、通常のプレビューには `make run` を使用してください。

ページビューはGoogleタグの自動計測に任せ、手動の `page_view` イベントは追加しません。既存ストリームでは、スクロール・外部リンククリック・サイト内検索・対応する埋め込み動画・ファイルダウンロードの拡張計測が有効です。フォーム操作の計測は無効です。

`privacy.googleAnalytics.respectDoNotTrack` をtrueにしており、ブラウザから追跡拒否が通知された場合は計測を開始しません。訪問者向けの説明は `/privacy/` に記載しています。

## 動作確認

1. ブログ管理用のGoogleアカウントで [Google Analytics](https://analytics.google.com/) を開く。
2. 対象プロパティと測定IDを確認する。
3. 本番サイトのトップ・記事をブラウザで開く。
4. GA4のリアルタイムレポートでページビュー、ページタイトル、イベントが届くことを確認する。

ブラウザのDo Not Track設定や広告ブロッカーなどで計測が停止している場合、そのアクセスは計測確認に使えません。確認のためにブラウザの保護設定を変更する必要はありません。

## Search Consoleとの連携

「管理 → Search Consoleのリンク」で、ドメインプロパティ `swiswiswift.com` と上記ウェブストリームを関連付けます。Googleアナリティクス側の閲覧権限を持つユーザーがSearch Consoleの検索データも閲覧できるため、連携前に対象と権限を確認してください。

関連Issue: [#2](https://github.com/takoikatakotako/swiswiswift.com/issues/2)

公式資料: [Hugoの組み込みGA4 partial](https://gohugo.io/templates/embedded/#google-analytics)、[Google Analyticsのセットアップ](https://support.google.com/analytics/answer/9304153?hl=ja)、[Search Consoleとの連携](https://support.google.com/analytics/answer/10737381?hl=ja)
