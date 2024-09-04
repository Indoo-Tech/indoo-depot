FROM openjdk:21-jdk-alpine

WORKDIR /depot

COPY build/libs/depot-0.0.1-SNAPSHOT.jar /depot/depot-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/admin/depot-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
