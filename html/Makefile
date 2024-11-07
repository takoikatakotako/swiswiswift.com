# S3_URI = "s3://swiswiswift.com"
# S3_URI = "s3://swiswiswift.com"
# CLOUDFRONT_DISTRIBUTION_ID = "E3R4J7BFG7GL89"

.PHONY: format
build:
	hugo -s hugo

# .PHONY: run
# run:
# 	hugo server -s hugo

# .PHONY: deploy
# deploy:
# 	aws s3 sync ./hugo/public ${S3_URI} --exact-timestamps --delete --profile swiswiswift
# 	aws cloudfront create-invalidation --distribution-id ${CLOUDFRONT_DISTRIBUTION_ID} --paths "/" --profile swiswiswift

# .PHONY: delete-cache
# delete-cache:
# 	aws cloudfront create-invalidation --distribution-id ${CLOUDFRONT_DISTRIBUTION_ID} --paths "/*" --profile swiswiswift
