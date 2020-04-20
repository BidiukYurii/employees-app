package com.test.demo.dto.employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateEmployeeDTO {

    @NotNull
    @NotBlank
    private String name;

    private boolean active;

    private long departmentId;

    public CreateEmployeeDTO() {
    }

    public CreateEmployeeDTO(String name, boolean active, long departmentId) {
        this.name = name;
        this.active = active;
        this.departmentId = departmentId;
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

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
