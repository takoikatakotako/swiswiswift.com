# Google AdSense

ブログ管理用のGoogleアカウントの既存AdSenseを使用します。アカウントメニューを確認し、対象サイトが `swiswiswift.com` であることを確認してから操作してください。

| 設定 | 値 |
| --- | --- |
| サイト | swiswiswift.com |
| サイトの状態 | 準備完了（2020年6月3日承認、2026年10月15日確認） |
| パブリッシャーID | pub-5587141252700968 |
| コード用ID | ca-pub-5587141252700968 |

IDは公開HTMLに含まれる識別子で、認証情報ではありません。

## サイト側の設定

`hugo/hugo.toml` の `params.adsense.enabled` と `publisherID` で管理します。無効にする場合は `enabled = false` にします。

`hugo/layouts/_partials/adsense.html` が、本番ビルドかつHugo server以外の場合にパブリッシャーのmetaタグを出力します。`posts` の記事ページではheadに非同期のAdSenseスクリプトを1回出力します。トップ、一覧、タグ、About、Products、プライバシーポリシーには広告スクリプトを出力しません。個別の記事のfront matterに `ads = false` を指定すると、その記事も配信対象から外せます。

以前の `google-ads` shortcodeは互換性のため残し、出力を空にしています。既存記事内の呼び出しはそのまま保持します。従来の手動広告ユニット、重複した読み込み、`data-adtest` は公開HTMLに出力されません。

`hugo/static/ads.txt` はルートの `/ads.txt` として公開します。AdSense管理画面に表示された次の行を使用しています。

```text
google.com, pub-5587141252700968, DIRECT, f08c47fec0942fa0
```

訪問者向けの説明は `/privacy/` に記載し、全ページのフッターからリンクします。

## AdSense管理画面の設定

2026年10月15日に保存した設定です。表示する広告数や位置はGoogleがページに応じて決定します。

- 自動広告: オン、自動最適化: オフ。
- バナー広告: オン。最大数は設定可能な最少の6、最小間隔は最大の1,000px。
- Multiplex、インテント重視、アンカー、サイドレール、全画面広告: オフ。

「プライバシーとメッセージ → 欧州の規制」には、Googleが自動作成した公開済みメッセージがあり、対象は `swiswiswift.com`、デフォルト言語は英語、追加31言語です。プライバシーポリシーURLを `https://swiswiswift.com/privacy/` に修正し、対象となる全地域で「同意しない」を表示、同意メッセージの自動最適化をオフにしました。同意を撤回するリンクはGoogleが対象の記事ページに自動追加します。

## 検証と公開

- 本番・development・AdSense無効の各ビルドで、847 HTMLファイルを検査。本番の全717記事にスクリプトが1回だけhead内に出力され、他のページ、development、無効設定では出力されないことを確認。
- `hugo server` の記事HTMLにAdSenseタグが出ないことを確認。
- `ads.txt` の内容、プライバシーポリシー、旧広告コードが残らないことを確認。

通常のブラウザ確認には `make run` / `hugo server` を使用してください。本番ビルドをブラウザで開くと実際の広告・計測コードが実行されます。ビルドとHTML検査のみでは広告リクエストは発生しません。

mainへのマージ後は既存CDが公開します。`https://swiswiswift.com/ads.txt` と記事のheadを確認し、「サイト → swiswiswift.com → ads.txt → 更新を確認」を実行します。Google側のクロール結果の反映には時間がかかる場合があります。

公式資料: [自動広告の設定](https://support.google.com/adsense/answer/9261307?hl=ja)、[ads.txt](https://support.google.com/adsense/answer/12171612?hl=ja)、[同意の撤回リンク](https://support.google.com/adsense/answer/10959060?hl=en-GB)
