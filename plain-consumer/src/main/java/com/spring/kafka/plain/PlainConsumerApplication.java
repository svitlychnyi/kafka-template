package com.spring.kafka.plain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class PlainConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlainConsumerApplication.class, args);
    }
}
