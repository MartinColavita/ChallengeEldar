# FROM: imagen base jdk 17 java
FROM openjdk:17-jdk-alpine3.13

MAINTAINER martincolavita@gmail.com

COPY target/tarjetasCredito-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]