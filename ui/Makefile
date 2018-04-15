
.PHONY: create build_env

APP_NAME=xmexersize-ui

build_env:
	docker build --target env . -t $(APP_NAME)-env
create:
	docker run -it -v "$$(pwd):/app" -t $(APP_NAME)-env npx create-react-app new-app
	mv new-app/* ./
	rm -rf new-app

build_dev:
	docker build --target dev . -t $(APP_NAME)-dev

run:
	docker run -it -v "$$(pwd):/app" -p 3000:3000 -p 35729:35729 -t $(APP_NAME)-dev npm start

release:
	docker build --target prod . -t $(APP_NAME)

run_prod:
	docker run -it -p 3000:80 $(APP_NAME)





