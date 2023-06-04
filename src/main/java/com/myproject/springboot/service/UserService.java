package com.myproject.springboot.service;

import com.myproject.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Integer id);

}
