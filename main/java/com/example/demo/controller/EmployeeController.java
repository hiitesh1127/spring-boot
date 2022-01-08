package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(@RequestParam(required = false) String city, @RequestParam(required = false) String name) {
        if(city != null && name != null) {
            return employeeService.getByCityAndName(city, name);
        } else if(city != null) {
            return employeeService.getByCity(city);
        } else if(name != null) {
            return employeeService.getByName(name);
        } else
            return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee e) {
        return employeeService.saveEmployee(e);
    }

//    @PutMapping("/employee")
//    public String updateEmployee(@RequestBody Employee e) {return employeeService.updateEmployee(e); }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody Employee e, @PathVariable String id) {return employeeService.updateEmployee(e, id); }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }



}
