FROM openjdk:17-jdk-slim
ENV KAFKA_HOST=kafka-01
ENV KAFKA_PORT=9092
COPY target/plain-producer-0.0.1-SNAPSHOT.jar plain-producer.jar
ENTRYPOINT ["java","-jar","/plain-producer.jar"]
