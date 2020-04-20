package com.test.demo.repository;

import com.test.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository {

  Employee save(Employee employee);

  Employee update(Employee employee);

  void delete(long employee);

  Employee findOne(long id);

  List<Employee> findAll();

  Page<Employee> findPage(Pageable pageable);

  List<Employee> findAllStartsWithName(String name);
}
