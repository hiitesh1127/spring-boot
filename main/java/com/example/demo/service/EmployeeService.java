package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeesById(int id) {
        return employeeRepository.findById(id);
    }

    public String saveEmployee(Employee e) {

            employeeRepository.save(e);
            return "Employee Saved!";

    }


    public String updateEmployee(Employee e, int id) {
        if(employeeRepository.existsById(id)) {
            e.setId(id);
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

    public List<Employee> getByCityAndName(String city, String name) {
        return employeeRepository.findAllByCityAndName(city, name);
    }

    public List<Employee> getByCity(String city) {
        return employeeRepository.findAllByCity(city);
    }

    public List<Employee> getByName(String name) {
        return employeeRepository.getByName(name);
    }





}