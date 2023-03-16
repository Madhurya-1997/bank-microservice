FROM openjdk:17 as build
MAINTAINER heritage
COPY /target/loans-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java", "-jar", "/loans-0.0.1-SNAPSHOT.jar"]