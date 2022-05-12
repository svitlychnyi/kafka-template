package com.spring.kafka.cdc.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.kafka.cdc.core.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserOutputStream {

	@Scheduled(fixedDelay = 15000)
	public void publishUserData() {
		User user = User.builder()
			.firstName("Hello")
			.lastName("World")
			.build();


	}

}
