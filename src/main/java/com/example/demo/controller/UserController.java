package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @PostMapping("/user")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
