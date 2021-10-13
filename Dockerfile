FROM openjdk:11
WORKDIR gif-rate
COPY build/libs/gif-rate-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gif-rate-0.0.1-SNAPSHOT.jar"]