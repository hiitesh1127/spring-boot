package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee e) {
        return employeeService.saveEmployee(e);
    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee e) {return employeeService.updateEmployee(e); }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }
}
