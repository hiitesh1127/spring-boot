package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    public String saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Saved";
    }

    public String deleteUser(int id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted Successfully";
        } else {
            return "User does not Exist";
        }
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }

}
