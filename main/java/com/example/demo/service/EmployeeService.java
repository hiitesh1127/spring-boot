package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public String saveEmployee(Employee e) {
        if(employeeRepository.existsById(e.getId())) {
            return "ID Already Exist!";
        } else {
            employeeRepository.save(e);
            return "Employee Saved!";
        }
    }

    
    //if we get only updated fields from frontend
    /*
    public String updateEmployee(Employee e, String id) {
                System.out.println("id " + id);
                Optional<Employee> emp = employeeRepository.findById(id);

                if(emp.isPresent()) {
                    Employee newEmployee = emp.get();

                    if(e.getName() != null) {
                        newEmployee.setName(e.getName());
                    }
                    if(e.getAge() != 0) {
                        newEmployee.setAge(e.getAge());
                    }
                    employeeRepository.save(newEmployee);
                    return "Employee Successfully Updated";
                }


        return "Employee Not found";

    }
    */

    // if we get full updated object from frontend
    public String updateEmployee(Employee e, String id) {
        if(employeeRepository.existsById(id)) {
            e.setId(id);
            employeeRepository.save(e);
            return "Employee Successfully Updated!";
        } else {
            return "Employee not Exist!";
        }
    }
    public String deleteEmployee(String id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted Successfully";
        } else {
            return "Employee does not Exist";
        }
    }

}
