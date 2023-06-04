package com.myproject.springboot.controller;

import com.myproject.springboot.model.User;
import com.myproject.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WelcomeController {

    @Autowired
    UserService userService;
@GetMapping("/")

    public String welcome(@RequestParam(defaultValue = "User") String name){
        return "Hi " + name + ", Welcome to my app!";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> fetchUserById(@PathVariable Integer id) {
        Optional<User> myUser = userService.getUserById(id);
       return ResponseEntity.ok(myUser);
    }
}
