package com.test.demo.repository;

import com.test.demo.model.Department;
import java.util.List;

public interface DepartmentRepository {

  void save(Department department);

  Department findOne(long id);

  List<Department> findAll();
}
