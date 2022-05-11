package com.spring.kafka.plain.config;

import java.time.Instant;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import com.spring.kafka.plain.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UsersOutputStream {

    private final StreamBridge streamBridge;

    @Value("${spring.cloud.stream.bindings.users-out-0.content-type}")
    private String streamOutMimeType;

    @Scheduled(fixedDelay = 15000)
    public void publishUserData() {
        UserDTO userDTO = UserDTO.builder()
            .id(UUID.randomUUID().toString())
            .eventType("CREATED")
            .firstName(RandomStringUtils.randomAlphabetic(10))
            .lastName(RandomStringUtils.randomAlphabetic(10))
            .city(RandomStringUtils.randomAlphabetic(10))
            .country("India")
            .email(RandomStringUtils.randomAlphabetic(10) + "@gmail.com")
            .mobileNumber(RandomStringUtils.randomNumeric(10))
            .eventId(UUID.randomUUID().toString())
            .eventTimestamp(Instant.now().getEpochSecond())
            .createdOn(Instant.now().getEpochSecond())
            .updatedOn(Instant.now().getEpochSecond())
            .build();

        Message<String> message = MessageBuilder.withPayload(userDTO.toString()).build();
        streamBridge.send("users-out-0", message, MimeType.valueOf(streamOutMimeType));
    }

}
