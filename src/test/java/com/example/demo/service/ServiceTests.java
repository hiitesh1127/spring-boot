package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTests {
    @InjectMocks
    private EmployeeService employeeService;

    @InjectMocks
    private UserService userService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getEmployeesTest() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee1 = new Employee(1, "hitesh", 21, "Khargone");
        Employee employee2 = new Employee(2, "chetan", 21, "Indore");

        employeeList.add(employee1);
        employeeList.add(employee2);

        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        assertEquals(2, employeeService.getEmployees().size());
    }

    @Test
    public void getUser() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User(1, "admin", "asdf", true, "ROLE_ADMIN");
        User user2 = new User(1, "user", "asdf", true, "ROLE_USER");

        userList.add(user1);
        userList.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(userList);
        assertEquals(2, userService.getUsers().size());
    }

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee(1, "hitesh", 21, "Khargone");
        //employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        assertEquals("Employee Saved!", employeeService.saveEmployee(employee));
    }



//    @Test
//    public void updateEmployeeTest() {
//        Employee employee = new Employee(1, "hitesh", "pass", true, "ROLE_USER");
//
//    }

//    @Test
//    public void deleteEmployeeTest() {
//        Employee employee = new Employee(1, "hitesh", "pass", true, "ROLE_USER");
//       // employeeService.deleteEmployee(employee.getId());
//       // Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(employee.getId());
//        Mockito.doReturn("dfas").when(employeeRepository.deleteById(employee.getId()));
//
//        assertEquals("Employee deleted Successfully", employeeService.deleteEmployee(employee.getId()));
//
//
//    }


}
