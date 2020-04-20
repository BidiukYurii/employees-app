package com.test.demo.repository.dao;

import com.test.demo.model.User;
import com.test.demo.repository.UserRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class UserDAO implements UserRepository {

    private final String SQL_FIND_BY_NAME = "SELECT id, username, password FROM user WHERE username = ?";
    private final String SQL_SAVE = "INSERT INTO user (username, password) VALUES (?, ?);";

    private final JdbcTemplate jdbcTemplate;


    UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, BeanPropertyRowMapper.newInstance(User.class), username);
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update(SQL_SAVE, user.getUsername(), user.getPassword());
        return findByUsername(user.getUsername());
    }
}
