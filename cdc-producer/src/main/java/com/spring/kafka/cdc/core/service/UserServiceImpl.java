package com.spring.kafka.cdc.core.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.kafka.cdc.core.domain.User;
import com.spring.kafka.cdc.core.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(final User user) {
        Assert.notNull(user, "user");
        return userRepository.save(user);
    }
}
