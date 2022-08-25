FROM maven:3.8.6-jdk-8-slim as base
WORKDIR /app
COPY ../ .
RUN mvn compile
ENTRYPOINT [ "mvn", "test"]