package com.test.demo.service;

import com.test.demo.repository.DepartmentRepository;
import com.test.demo.model.Department;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public void create(Department department) {
    departmentRepository.save(department);
  }

  @Override
  public Department findOne(long id) {
    return departmentRepository.findOne(id);
  }

  @Override
  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

}
