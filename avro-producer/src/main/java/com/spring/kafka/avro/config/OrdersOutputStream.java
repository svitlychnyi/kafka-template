package com.spring.kafka.avro.config;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import com.github.javafaker.Faker;
import com.spring.kafka.avro.generated.order.OrderEvent;
import com.spring.kafka.avro.generated.user.UserEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrdersOutputStream {

	Faker faker = new Faker();

	private final StreamBridge streamBridge;

	@Value("${spring.cloud.stream.bindings.orders-out-0.content-type}")
	private String streamOutMimeType;

	@Scheduled(fixedDelay = 15000)
	public void publishOrderData() {
		UserEvent userDTO = UserEvent.newBuilder()
			.setId(UUID.randomUUID().toString())
			.setEventType("CREATED")
			.setFirstName(faker.name().firstName())
			.setLastName(faker.name().lastName())
			.setCity(faker.country().capital())
			.setCountry(faker.country().name())
			.setEmail(faker.internet().emailAddress())
			.setMobileNumber(faker.phoneNumber().phoneNumber())
			.setEventId(UUID.randomUUID().toString())
			.setEventTimestamp(Instant.now().getEpochSecond())
			.setCreatedOn(Instant.now().getEpochSecond())
			.setUpdatedOn(Instant.now().getEpochSecond())
			.build();

		Random random = new Random();
		OrderEvent orderDTO = OrderEvent.newBuilder()
			.setId(UUID.randomUUID().toString())
			.setUser(userDTO)
			.setProduct(faker.app().name())
			.setPrice(faker.number().randomNumber())
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
