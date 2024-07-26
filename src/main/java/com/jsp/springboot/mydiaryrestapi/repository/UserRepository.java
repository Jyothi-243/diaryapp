package com.jsp.springboot.mydiaryrestapi.repository;

import com.jsp.springboot.mydiaryrestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);
}
