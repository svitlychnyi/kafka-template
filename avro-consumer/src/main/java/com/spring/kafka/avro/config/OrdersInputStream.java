package com.spring.kafka.avro.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.spring.kafka.avro.generated.order.OrderEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrdersInputStream {

	@Bean
	public Consumer<Message<OrderEvent>> orders() {
		return message -> {
			log.info("\n---\nHeaders: {}\n\nPayload: {}\n---", message.getHeaders(), message.getPayload());
		};
	}

}
