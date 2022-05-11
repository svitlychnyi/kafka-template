package com.spring.kafka.avro.config;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import com.spring.kafka.avro.generated.order.OrderEvent;
import com.spring.kafka.avro.generated.user.UserEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrdersOutputStream {

	private final StreamBridge streamBridge;

	@Value("${spring.cloud.stream.bindings.orders-out-0.content-type}")
	private String streamOutMimeType;

	@Scheduled(fixedDelay = 15000)
	public void publishOrderData() {
		UserEvent userDTO = UserEvent.newBuilder()
			.setId(UUID.randomUUID().toString())
			.setEventType("CREATED")
			.setFirstName(RandomStringUtils.randomAlphabetic(10))
			.setLastName(RandomStringUtils.randomAlphabetic(10))
			.setCity(RandomStringUtils.randomAlphabetic(10))
			.setCountry("India")
			.setEmail(RandomStringUtils.randomAlphabetic(10) + "@gmail.com")
			.setMobileNumber(RandomStringUtils.randomNumeric(10))
			.setEventId(UUID.randomUUID().toString())
			.setEventTimestamp(Instant.now().getEpochSecond())
			.setCreatedOn(Instant.now().getEpochSecond())
			.setUpdatedOn(Instant.now().getEpochSecond())
			.build();

		Random random = new Random();
		OrderEvent orderDTO = OrderEvent.newBuilder()
			.setId(UUID.randomUUID().toString())
			.setUser(userDTO)
			.setProduct(UUID.randomUUID().toString())
			.setPrice(random.nextDouble())
			.setActive(random.nextBoolean())
			.setEventId(UUID.randomUUID().toString())
			.setEventType("CREATED")
			.setEventTimestamp(Instant.now().getEpochSecond())
			.setCreatedOn(Instant.now().getEpochSecond())
			.setUpdatedOn(Instant.now().getEpochSecond())
			.build();

		Message<OrderEvent> message = MessageBuilder.withPayload(orderDTO).build();
		streamBridge.send("orders-out-0", message, MimeType.valueOf(streamOutMimeType));
	}

}
