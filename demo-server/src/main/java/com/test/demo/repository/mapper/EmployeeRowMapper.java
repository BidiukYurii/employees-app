package com.test.demo.repository.mapper;

import com.test.demo.model.Department;
import com.test.demo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department(resultSet.getLong("department.id"),
                resultSet.getString("department.name"));

        return new Employee(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getBoolean("active"),
                department);
    }
}
