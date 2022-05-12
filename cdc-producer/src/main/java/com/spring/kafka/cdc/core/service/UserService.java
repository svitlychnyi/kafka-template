package com.spring.kafka.cdc.core.service;

import com.spring.kafka.cdc.core.domain.User;

public interface UserService {

    /**
     * Persist User
     * @param user
     * @return
     */
    User saveUser(User user);
}
