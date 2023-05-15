package com.myproject.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
@GetMapping("/")

    public String welcome(@RequestParam(defaultValue = "User") String name){

    return "Hi " + name + ", Welcome to my app!";
    }
}
