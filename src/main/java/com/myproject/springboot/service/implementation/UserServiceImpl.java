package com.myproject.springboot.service.implementation;

import com.myproject.springboot.repository.UsersRepo;
import com.myproject.springboot.model.User;
import com.myproject.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepo repo;

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }
}