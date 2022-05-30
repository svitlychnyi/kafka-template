FROM ${REGISTRY}openjdk:17-jdk-slim

COPY target/plain-consumer-0.0.1-SNAPSHOT.jar plain-consumer.jar
ENTRYPOINT ["java","-jar","/plain-consumer.jar"]
