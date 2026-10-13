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

公開用HTMLは `hugo/public/` に生成されます。生成物はGitに含めません。

## 構成

- `hugo/content/posts/`: 記事のMarkdownと画像。
- `hugo/themes/swiswiswift/`: ブログのデザイン・テンプレート。
- `hugo/layouts/_shortcodes/`: 既存記事で利用しているショートコード。
- `prototypes/2023/`: `swiswiswift.com-new` にあったHTML/CSS試作の保存。
- `html/`: 2024年のHTMLデザイン試作。Hugoのビルドには使用しません。
- `docs/gist-migration.json`: Gistの取得リビジョン、コードのSHA-256、移行先記事の対応表。
- `docs/migration.md`: 移行範囲と既存データの修正点。
- `docs/tagging.md`: タグの表記・分類ルール。

コードは記事内のMarkdownコードブロックで管理します。Gistから取得したコードはファイル名ごとに表示し、コード表示にGitHubへのアクセスは必要ありません。元のGistは残しています。

## 公開

現在の `.github/workflows/cd.yml` はmainへのpushで、管理アカウントの既存S3バケットへデプロイします。

共有アカウントの新しいS3・CloudFrontは構築済みですが、このリポジトリのデプロイ先とDNSはまだ切り替えていません。インフラの定義は `aws-iac/terraform/accounts/shared` にあります。

新しいブログのビルド・編集には `swiswiswift.com-new` リポジトリは不要です。
