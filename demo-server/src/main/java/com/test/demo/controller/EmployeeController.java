package com.test.demo.controller;

import com.test.demo.dto.employee.CreateEmployeeDTO;
import com.test.demo.dto.employee.EmployeeDTO;
import com.test.demo.model.Employee;
import com.test.demo.service.EmployeeService;
import com.test.demo.util.EmployeeDTOMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employee")
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO save(@Valid @RequestBody CreateEmployeeDTO employeeRequest) {
        Employee employee = EmployeeDTOMapper.map(employeeRequest);
        return EmployeeDTOMapper.map(employeeService.create(employee));
    }

    @PutMapping
    public EmployeeDTO update(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = EmployeeDTOMapper.map(employeeDTO);
        return EmployeeDTOMapper.map(employeeService.update(employee));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return EmployeeDTOMapper.map(employeeService.findAll());
    }

    @GetMapping("/page")
    public Page<EmployeeDTO> getAllPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.findAllByPage(pageable).map(EmployeeDTOMapper::map);
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable long id) {
        return EmployeeDTOMapper.map(employeeService.findOne(id));
    }

    @GetMapping("/search")
    public List<EmployeeDTO> findByName(@RequestParam("name") String name) {
        return EmployeeDTOMapper.map(employeeService.findAllStartsWithName(name));
    }

}
