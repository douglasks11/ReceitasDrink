#build
FROM maven:3.6.3-jdk-11-slim AS build

WORKDIR /usr/src/app

COPY . ./

RUN mvn clean package

#Package
FROM openjdk:11-jre-slim

ARG JAR_NAME="service-discovery"

WORKDIR /usr/src/app

EXPOSE 8080

COPY --from=build /usr/src/app/target/${JAR_NAME}*.jar ./${JAR_NAME}.jar

CMD ["java","-jar", "./service-discovery.jar"]