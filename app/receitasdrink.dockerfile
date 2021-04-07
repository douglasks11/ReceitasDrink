#build
FROM maven:3.6.3-jdk-11-slim AS build

WORKDIR /usr/src/app

COPY . ./

RUN mvn clean package

#Package
FROM openjdk:11-jre-slim

ARG JAR_NAME="receitas-drinks"

WORKDIR /usr/src/app

EXPOSE 8080

COPY --from=build /usr/src/app/target/${JAR_NAME}*.jar ./app.jar

CMD ["java","-jar", "./app.jar"]