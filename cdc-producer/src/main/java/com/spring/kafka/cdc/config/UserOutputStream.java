package com.spring.kafka.cdc.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.spring.kafka.cdc.core.domain.User;
import com.spring.kafka.cdc.core.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserOutputStream {

	Faker faker = new Faker();
	private final UserService userService;

	@Scheduled(fixedDelay = 15000)
	public void publishUserData() {
		User user = User.builder()
			.firstName(faker.name().firstName())
			.lastName(faker.name().lastName())
			.build();

		userService.saveUser(user);
		log.info("User Saved to DB: {}", user);
	}

}
