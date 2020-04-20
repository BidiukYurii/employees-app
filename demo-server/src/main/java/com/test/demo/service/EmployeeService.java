package com.test.demo.service;

import com.test.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

  Employee create(Employee employee);

  Employee update(Employee employee);

  void delete(long id);

  Employee findOne(long id);

  List<Employee> findAll();

  Page<Employee> findAllByPage(Pageable pageable);

  List<Employee> findAllStartsWithName(String name);

}
