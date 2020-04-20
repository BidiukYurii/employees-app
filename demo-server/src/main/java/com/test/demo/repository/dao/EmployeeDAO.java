package com.test.demo.repository.dao;

import com.test.demo.model.Employee;
import com.test.demo.repository.EmployeeRepository;
import com.test.demo.repository.mapper.EmployeeRowMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
class EmployeeDAO implements EmployeeRepository {

    private final String SQL_SAVE = "INSERT INTO employees (name, active, department_id) VALUES (?, ?, ?);";
    private final String SQL_UPDATE = "UPDATE employees SET name = ?, active = ?, department_id = ? WHERE id = ?;";
    private final String SQL_DELETE = "DELETE  FROM employees WHERE id = ?;";
    private final String SQL_FIND_ONE = "SELECT employees.id, employees.name, employees.active, department.id, department.name FROM employees JOIN departments AS department ON department.id = department_id WHERE employees.id = ?";
    private final String SQL_FIND_ALL = "SELECT employees.id, employees.name, employees.active, department.id, department.name FROM employees JOIN departments AS department ON department.id = department_id";
    private final String SQL_COUNT_ALL = "SELECT count(1) AS row_count FROM employees";
    private final String SQL_FIND_PAGE = "SELECT employees.id, employees.name, employees.active, department.id, department.name FROM employees JOIN departments AS department ON department.id = department_id LIMIT ? OFFSET ?;";
    private final String SQL_FIND_ALL_BY_NAME = "SELECT employees.id, employees.name, employees.active, department.id, department.name FROM employees JOIN departments AS department ON department.id = department_id WHERE employees.name LIKE ?";

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> mapper;

    EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = new EmployeeRowMapper();
    }

    @Override
    public Employee save(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setBoolean(2, employee.isActive());
            ps.setLong(3, employee.getDepartment().getId());

            return ps;
        }, keyHolder);

        return findOne(keyHolder.getKey().longValue());
    }

    @Override
    public Employee update(Employee employee) {
        jdbcTemplate.update(SQL_UPDATE, employee.getName(), employee.isActive(), employee.getDepartment().getId(), employee.getId());

        return findOne(employee.getId());
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    @Override
    public Employee findOne(long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_ONE, this.mapper, id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, this.mapper);
    }

    @Override
    public Page<Employee> findPage(Pageable pageable) {
        int total = jdbcTemplate.queryForObject(SQL_COUNT_ALL, (rs, rowNum) -> rs.getInt(1));

        List<Employee> employees = jdbcTemplate.query(SQL_FIND_PAGE, this.mapper, pageable.getPageSize(), pageable.getOffset());

        return new PageImpl<>(employees, pageable, total);
    }

    @Override
    public List<Employee> findAllStartsWithName(String name) {
        return jdbcTemplate.query(SQL_FIND_ALL_BY_NAME, this.mapper, name + "%");
    }

}
