FROM openjdk:10-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/xmexersize-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "xmexersize-0.0.1-SNAPSHOT.jar"]