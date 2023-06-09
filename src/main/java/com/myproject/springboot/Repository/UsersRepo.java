package com.myproject.springboot.repository;

import com.myproject.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<User, Integer> {

}
