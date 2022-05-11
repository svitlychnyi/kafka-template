FROM openjdk:17-jdk-slim
ENV KAFKA_HOST=kafka-01
ENV KAFKA_PORT=9092
ENV SCHEMA_REGISTRY_HOST=confluent-schema-registry
ENV SCHEMA_REGISTRY_PORT=8081
COPY target/avro-consumer-0.0.1-SNAPSHOT.jar avro-consumer.jar
ENTRYPOINT ["java","-jar","/avro-consumer.jar"]
