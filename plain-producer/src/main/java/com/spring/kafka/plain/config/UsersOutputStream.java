package com.spring.kafka.plain.config;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import com.github.javafaker.Faker;
import com.spring.kafka.plain.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UsersOutputStream {

    Faker faker = new Faker();

    private final StreamBridge streamBridge;

    @Value("${spring.cloud.stream.bindings.users-out-0.content-type}")
    private String streamOutMimeType;

    @Scheduled(fixedDelay = 15000)
    public void publishUserData() {
        UserDTO userDTO = UserDTO.builder()
            .id(UUID.randomUUID().toString())
            .eventType("CREATED")
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .city(faker.country().capital())
            .country(faker.country().name())
            .email(faker.internet().emailAddress())
            .mobileNumber(faker.phoneNumber().phoneNumber())
            .eventId(UUID.randomUUID().toString())
            .eventTimestamp(Instant.now().getEpochSecond())
            .createdOn(Instant.now().getEpochSecond())
            .updatedOn(Instant.now().getEpochSecond())
            .build();

        Message<String> message = MessageBuilder.withPayload(userDTO.toString()).build();
        streamBridge.send("users-out-0", message, MimeType.valueOf(streamOutMimeType));
    }

}
