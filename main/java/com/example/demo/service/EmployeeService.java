package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeesById(int id) {
        return employeeRepository.findById(id);
    }

    public String saveEmployee(Employee e) {


        e.setPassword(passwordEncoder.encode(e.getPassword()));
        employeeRepository.save(e);
        return "Employee Saved!";



    }


    public String updateEmployee(Employee e, int id) {
        if(employeeRepository.existsById(id)) {
            e.setId(id);
            e.setPassword(passwordEncoder.encode(e.getPassword()));
            employeeRepository.save(e);
            return "Employee Saved!";
        } else {
            return "Employee not Exist!";
        }
    }

    public String deleteEmployee(int id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted Successfully";
        } else {
            return "Employee does not Exist";
        }
    }





}