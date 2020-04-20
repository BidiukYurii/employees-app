package com.test.demo.model;

public class Employee {

  private Long id;

  private String name;

  private boolean active;

  private Department department;

  public Employee() {}

  public Employee(Long id, String name, boolean active, Department department) {
    this.id = id;
    this.name = name;
    this.active = active;
    this.department = department;
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
