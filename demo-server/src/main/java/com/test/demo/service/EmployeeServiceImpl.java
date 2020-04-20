package com.test.demo.service;

import com.test.demo.repository.EmployeeRepository;
import com.test.demo.model.Employee;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee create(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee update(Employee employee) {
    return employeeRepository.update(employee);
  }

  @Override
  public void delete(long id) {
    employeeRepository.delete(id);
  }

  @Override
  public Employee findOne(long id) {
    return employeeRepository.findOne(id);
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Page<Employee> findAllByPage(Pageable pageable) {
    return employeeRepository.findPage(pageable);
  }

  @Override
  public List<Employee> findAllStartsWithName(String name) {
    return employeeRepository.findAllStartsWithName(name);
  }
}
