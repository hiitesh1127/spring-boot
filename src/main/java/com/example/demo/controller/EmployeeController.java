package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return ("<h1>HOME PAGE</h1>");
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
            return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee e) {
        return employeeService.saveEmployee(e);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody Employee e, @PathVariable int id) {return employeeService.updateEmployee(e, id); }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

}