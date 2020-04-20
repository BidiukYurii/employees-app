package com.test.demo.repository;

import com.test.demo.model.User;

public interface UserRepository {
    User findByUsername(String username);

    User save(User user);
}
