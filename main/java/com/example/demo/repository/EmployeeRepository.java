package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByCity(String city);
    //List<Employee> findAllByAgeBetween(int a, int b);
    List<Employee> getByName(String name);
    List<Employee> findAllByCityAndName(String city, String name);
}