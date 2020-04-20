package com.test.demo.controller;

import com.test.demo.dto.department.CreateDepartmentDTO;
import com.test.demo.dto.department.DepartmentDTO;
import com.test.demo.model.Department;
import com.test.demo.service.DepartmentService;
import com.test.demo.util.DepartmentDTOMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/department")
@CrossOrigin
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public void save(@Valid @RequestBody CreateDepartmentDTO departmentDTO) {
        Department department = DepartmentDTOMapper.map(departmentDTO);
        departmentService.create(department);
    }

    @GetMapping
    public List<DepartmentDTO> getAll() {
        return DepartmentDTOMapper.map(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable long id) {
        return DepartmentDTOMapper.map(departmentService.findOne(id));
    }
}
