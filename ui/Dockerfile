FROM node:9 as env
RUN mkdir /app
WORKDIR /app

FROM node:9 as dev

ADD yarn.lock /yarn.lock
ADD package.json /package.json

ENV NODE_PATH=/node_modules
ENV PATH=$PATH:/node_modules/.bin
RUN yarn

WORKDIR /app
ADD . /app

EXPOSE 3000
EXPOSE 35729

FROM node:9 as build
COPY --from=dev /yarn.lock /
COPY --from=dev /package.json /
COPY --from=dev /node_modules /node_modules
COPY --from=dev /app /app

ENV NODE_PATH=/node_modules
ENV PATH=$PATH:/node_modules/.bin

WORKDIR /app
RUN npm run-script build

FROM nginx as prod
COPY --from=build /app/build /usr/share/nginx/html



