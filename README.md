# すいすいSwift

`swiswiswift.com` のHugoブログです。`swiswiswift.com-new` で作業した記事・テンプレートの改修を本体へ取り込んでいます。

## ローカルで確認する

Hugo extended v0.167.0を使用します。バージョンは `.hugo-version` に固定し、デプロイCIもこのファイルを参照します。

macOSでHomebrewを使う場合は、`brew upgrade hugo` で更新し、`hugo version` でバージョンを確認してください。

```sh
make run
```

`http://localhost:1313/` でプレビューできます。

```sh
make build
```

公開用HTMLは `hugo/public/` に生成されます。ビルド時には古い生成物を削除し、削除・改名した記事やタグのファイルがデプロイに混ざることを防ぎます。生成物はGitに含めません。

## 構成

- `hugo/content/posts/`: 記事のMarkdownと画像。
- `hugo/themes/swiswiswift/`: ブログのデザイン・テンプレート。
- `hugo/layouts/_shortcodes/`: 既存記事で利用しているショートコード。
- `prototypes/2023/`: `swiswiswift.com-new` にあったHTML/CSS試作の保存。
- `html/`: 2024年のHTMLデザイン試作。Hugoのビルドには使用しません。
- `docs/gist-migration.json`: Gistの取得リビジョン、コードのSHA-256、移行先記事の対応表。
- `docs/migration.md`: 移行範囲と既存データの修正点。
- `docs/tagging.md`: タグの表記・分類ルール。
- `docs/search-console.md`: Search Consoleの管理アカウント確認・サイトマップ送信手順。
- `docs/analytics.md`: GA4の測定ID・本番限定の計測・動作確認手順。

コードは記事内のMarkdownコードブロックで管理します。Gistから取得したコードはファイル名ごとに表示し、コード表示にGitHubへのアクセスは必要ありません。元のGistは残しています。

## 公開

`.github/workflows/cd.yml` はmainへのpushでHugoをビルドし、共有アカウントの `s3://swiswiswift-content-579039992557` へ同期します。アップロードが成功するとCloudFront `E166LFVQ8I6UII` のキャッシュを更新します。

GitHub ActionsはOIDCで共有アカウントの `swiswiswift-github-actions` ロールへ認証します。mainへのpushだけが対象です。同時デプロイは直列に実行します。

移行先の確認URLは `https://dnr9o12vzic9u.cloudfront.net/` です。独自ドメインの証明書・CloudFront関連付け・DNS切り替えはインフラ側で管理します。定義は `aws-iac/terraform/accounts/shared` と `cloudflare-iac` にあります。

ローカルからデプロイする場合は、`aws sso login --profile rikako-shared-sso` で認証してから `make deploy` を実行します。別の認証プロファイルを使う場合は `make deploy DEPLOY_PROFILE=プロファイル名` を指定できます。

新しいブログのビルド・編集には `swiswiswift.com-new` リポジトリは不要です。
