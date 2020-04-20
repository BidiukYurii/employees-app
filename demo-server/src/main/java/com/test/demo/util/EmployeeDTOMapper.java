package com.test.demo.util;


import com.test.demo.dto.employee.CreateEmployeeDTO;
import com.test.demo.dto.employee.EmployeeDTO;
import com.test.demo.model.Employee;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeDTOMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private EmployeeDTOMapper() {
    }

    public static Employee map(CreateEmployeeDTO dto) {
        return modelMapper.typeMap(CreateEmployeeDTO.class, Employee.class)
                .addMapping(CreateEmployeeDTO::getDepartmentId,
                        (Employee employee, Long o) -> employee.getDepartment().setId(o)).map(dto);
    }

    public static EmployeeDTO map(Employee employee) {
        return modelMapper.typeMap(Employee.class, EmployeeDTO.class)
                .addMapping(src -> src.getDepartment().getId(),
                        (EmployeeDTO dto, Long id) -> dto.getDepartment().setId(id))
                .map(employee);
    }

    public static Employee map(EmployeeDTO dto) {
        return modelMapper.typeMap(EmployeeDTO.class, Employee.class)
                .addMapping(src -> src.getDepartment().getId(),
                        (Employee employee, Long o) -> employee.getDepartment().setId(o))
                .map(dto);
    }

    public static List<EmployeeDTO> map(List<Employee> employees) {
        return employees.stream().map(EmployeeDTOMapper::map).collect(Collectors.toList());
    }

}
