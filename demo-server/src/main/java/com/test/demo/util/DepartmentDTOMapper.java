package com.test.demo.util;

import com.test.demo.dto.department.CreateDepartmentDTO;
import com.test.demo.dto.department.DepartmentDTO;
import com.test.demo.model.Department;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class DepartmentDTOMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private DepartmentDTOMapper() {}

    public static Department map(CreateDepartmentDTO dto) {
        return modelMapper.map(dto, Department.class);
    }

    public static DepartmentDTO map(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public static List<DepartmentDTO> map(List<Department> departments) {
        return departments.stream().map(DepartmentDTOMapper::map).collect(Collectors.toList());
    }
}
