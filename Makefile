APP_NAME=xmexersize


.PHONY: build_backend run_backend build_ui run_ui run_all

all: build_backend build_ui run_all

build_backend:
	docker build --target prod . -t $(APP_NAME)-backend

build_ui:
	docker build --target prod ./ui -t $(APP_NAME)-ui

run_backend:
	docker run -it -p 8080:8080 ${APP_NAME}-backend

run_ui:
	docker run -it -p 3000:80 ${APP_NAME}-ui

run_all:
	docker run --name ${APP_NAME}-backend -d -p 8080:8080 ${APP_NAME}-backend
	docker run --name ${APP_NAME}-ui -d -p 3000:80 ${APP_NAME}-ui
	@echo "You can check out UI at http://localhost:3000/ or check out API at http://localhost:8080/"

stop:
	docker rm -f ${APP_NAME}-backend
	docker rm -f ${APP_NAME}-ui

