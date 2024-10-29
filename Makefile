.PHONY: build
build:
	hugo -s hugo

.PHONY: run
run:
	hugo server -s hugo
