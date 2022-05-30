FROM ${REGISTRY}openjdk:17-jdk-slim
COPY target/avro-producer-0.0.1-SNAPSHOT.jar avro-producer.jar
ENTRYPOINT ["java","-jar","/avro-producer.jar"]
