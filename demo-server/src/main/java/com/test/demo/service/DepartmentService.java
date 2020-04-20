package com.test.demo.service;

import com.test.demo.model.Department;
import java.util.List;

public interface DepartmentService {

  void create(Department department);

  Department findOne(long id);

  List<Department> findAll();
}
