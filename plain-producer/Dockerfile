FROM ${REGISTRY}openjdk:17-jdk-slim

COPY target/plain-producer-0.0.1-SNAPSHOT.jar plain-producer.jar
ENTRYPOINT ["java","-jar","/plain-producer.jar"]
