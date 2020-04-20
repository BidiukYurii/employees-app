package com.test.demo.repository.dao;

import com.test.demo.model.Department;
import com.test.demo.repository.DepartmentRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class DepartmentDAO implements DepartmentRepository {

    private final String SQL_SAVE = "INSERT INTO departments (name) VALUES (?);";
    private final String SQL_FIND_BY_ID = "SELECT id, name FROM departments WHERE id = ?;";
    private final String SQL_FIND_ALL = "SELECT id, name FROM departments;";

    private final JdbcTemplate jdbcTemplate;

    DepartmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Department department) {
        jdbcTemplate.update(SQL_SAVE, department.getName());
    }

    @Override
    public Department findOne(long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, BeanPropertyRowMapper.newInstance(Department.class), id);
    }

    @Override
    public List<Department> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, BeanPropertyRowMapper.newInstance(Department.class));
    }

}
