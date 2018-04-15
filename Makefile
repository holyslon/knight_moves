APP_NAME=xmexersize


.PHONY: build run

build:
	mvn package
	docker build . -t ${APP_NAME}

run:
	docker run -it -p 8080:8080 ${APP_NAME}