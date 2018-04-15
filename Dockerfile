FROM maven:3-jdk-10-slim as build
WORKDIR /app
ADD . /app
RUN mvn package


FROM openjdk:10-jre-slim as prod
COPY --from=build /app/target/xmexersize-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "xmexersize-0.0.1-SNAPSHOT.jar"]