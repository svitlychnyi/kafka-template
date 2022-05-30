FROM ${REGISTRY}openjdk:17-jdk-slim

COPY target/avro-consumer-0.0.1-SNAPSHOT.jar avro-consumer.jar
ENTRYPOINT ["java","-jar","/avro-consumer.jar"]
