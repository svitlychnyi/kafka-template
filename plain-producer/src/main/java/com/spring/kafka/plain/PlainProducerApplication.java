package com.spring.kafka.plain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlainProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlainProducerApplication.class, args);
    }
}
