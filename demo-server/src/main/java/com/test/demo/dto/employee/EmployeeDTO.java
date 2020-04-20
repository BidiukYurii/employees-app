package com.test.demo.dto.employee;

import com.test.demo.dto.department.DepartmentDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeDTO {

    private long id;

    @NotBlank
    private String name;

    private boolean active;

    @NotNull
    private DepartmentDTO department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, boolean active, DepartmentDTO department) {
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

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }
}
