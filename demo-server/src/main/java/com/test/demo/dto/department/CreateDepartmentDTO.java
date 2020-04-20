package com.test.demo.dto.department;

import javax.validation.constraints.NotBlank;

public class CreateDepartmentDTO {

    @NotBlank
    private String name;

    CreateDepartmentDTO() {}

    public CreateDepartmentDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
