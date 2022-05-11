FROM openjdk:17-jdk-slim
ENV KAFKA_HOST=kafka-01
ENV KAFKA_PORT=9092
COPY target/plain-consumer-0.0.1-SNAPSHOT.jar plain-consumer.jar
ENTRYPOINT ["java","-jar","/plain-consumer.jar"]
