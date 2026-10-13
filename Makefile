S3_URI ?= s3://swiswiswift-content-579039992557
CLOUDFRONT_DISTRIBUTION_ID ?= E166LFVQ8I6UII
DEPLOY_PROFILE ?= rikako-shared-sso

.PHONY: build
build:
	hugo -s hugo

.PHONY: run
run:
	hugo server -s hugo

.PHONY: deploy
deploy: build
	aws s3 sync ./hugo/public "${S3_URI}" --exact-timestamps --delete --profile "${DEPLOY_PROFILE}"
	aws cloudfront create-invalidation --distribution-id "${CLOUDFRONT_DISTRIBUTION_ID}" --paths '/*' --profile "${DEPLOY_PROFILE}"

.PHONY: delete-cache
delete-cache:
	aws cloudfront create-invalidation --distribution-id "${CLOUDFRONT_DISTRIBUTION_ID}" --paths '/*' --profile "${DEPLOY_PROFILE}"
