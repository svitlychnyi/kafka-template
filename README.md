## Spring Cloud Application using Kafka, Avro and Confluent Schema Registry

### Links
* [Why Avro for Kafka Data?](https://www.confluent.io/blog/avro-kafka-data/)
* [Standardize Data Format for Kafka Event streams using Apache Avro and Schema Evolution](https://medium.com/nerd-for-tech/standardize-data-format-for-kafka-event-streams-using-apache-avro-and-schema-evolution-a2df6924b54c)
* [Schema evolution in Avro, Protocol Buffers and Thrift](https://martin.kleppmann.com/2012/12/05/schema-evolution-in-avro-protocol-buffers-thrift.html)
* [Change Event Message Structure](https://developer.salesforce.com/docs/atlas.en-us.change_data_capture.meta/change_data_capture/cdc_message_structure.htm)

## Overview

Project consist of kafka infrastructure, set of consumers / producers and shared schema in a separate folder.
The main target of the project is to check how Apache Kafka can work with Confluent Schema Registry and Confluent Connect.

It also has a goal of showing the way of integration and working with avro schemas.


### Setup infrastructure
``` shell
$ mvn install

$ docker-compose up -d
$ docker-compose ps
          Name                         Command                       State                                   Ports                        
------------------------------------------------------------------------------------------------------------------------------------------
app-avro-consumer           java -jar /avro-consumer.jar     Up                                                                           
app-avro-producer           java -jar /avro-producer.jar     Up                                                                           
confluent-connect           /etc/confluent/docker/run        Up (health: starting)   0.0.0.0:8082->8082/tcp, 8083/tcp, 9092/tcp           
confluent-schema-registry   /etc/confluent/docker/run        Up (health: starting)   0.0.0.0:28081->28081/tcp, 8081/tcp                   
kafka-01                    /opt/bitnami/scripts/kafka ...   Up                      9092/tcp, 0.0.0.0:29091->9093/tcp                    
kafka-02                    /opt/bitnami/scripts/kafka ...   Up                      9092/tcp, 0.0.0.0:29092->9093/tcp                    
kafka-03                    /opt/bitnami/scripts/kafka ...   Up                      9092/tcp, 0.0.0.0:29093->9093/tcp                    
zookeeper-01                /opt/bitnami/scripts/zooke ...   Up                      0.0.0.0:60215->2181/tcp, 2888/tcp, 3888/tcp, 8080/tcp
```

### Start Producer Manually
Navigate to avro-producer and run `AvroProducerApplication.java as Java Application`. The producer starts and will publish messages every 15 seconds.

### Start Consumer Manually
Navigate to avro-consumer and run `AvroConsumerApplication.java as Java Application`. The application will consume application.
``` txt
---
Headers: {kafka_offset=0, scst_nativeHeadersPresent=true, kafka_consumer=org.apache.kafka.clients.consumer.KafkaConsumer@d114e1, deliveryAttempt=1, kafka_timestampType=CREATE_TIME, id=d90390fa-b0f4-3757-dc35-3afbd4c7841e, kafka_receivedPartitionId=1, contentType=application/vnd.orderevent.v1+avro, kafka_receivedTopic=com.spring.kafka.avro.neworder, kafka_receivedTimestamp=1652276113356, kafka_groupId=eventServiceGroup, timestamp=1652276113370}

Payload: {"eventId": "8ace1b1b-1e0e-48b5-9a0e-dd9564605ba0", "eventType": "CREATED", "eventTimestamp": 1652276113, "id": "d9e6f333-a01f-4691-b1e8-4c7bb0df00e0", "user": {"eventId": "d5a3f291-bdb3-4356-9f42-a49acdc259b2", "eventType": "CREATED", "eventTimestamp": 1652276113, "id": "6751e8df-5ab2-4bef-b7a9-324ac3e2fd70", "firstName": "qNoxsKTJTq", "lastName": "aiFGJKzGhv", "email": "ZKElFtQIOL@gmail.com", "mobileNumber": "9107572813", "city": "MheUVYerCm", "country": "India", "createdOn": 1652276113, "updatedOn": 1652276113}, "product": "83d9032b-237b-4aa5-b3a8-c7a3c346a6ef", "price": 0.4661009730146961, "createdOn": 1652276113, "updatedOn": 1652276113, "active": false}
---
```

### Refs

#### General 
* https://www.reddit.com/r/apachekafka/comments/tsr9dx/docker_compose_file_for_kafka_and_kafka_connect/
* https://www.reddit.com/r/apachekafka/comments/tsr9dx/docker_compose_file_for_kafka_and_kafka_connect/
* https://docs.bitnami.com/tutorials/build-messaging-cluster-apache-kafka-mongodb-kubernetes/
* https://github.com/bitnami/bitnami-docker-kafka

#### Kafka
* https://hub.docker.com/r/bitnami/kafka/
* https://www.baeldung.com/ops/kafka-docker-setup

#### Confluent Stack
* https://docs.confluent.io/platform/current/installation/docker/config-reference.html
