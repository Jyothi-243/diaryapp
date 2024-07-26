package com.jsp.springboot.mydiaryrestapi.controllers;

import com.jsp.springboot.mydiaryrestapi.entities.Entry;
import com.jsp.springboot.mydiaryrestapi.entities.User;
import com.jsp.springboot.mydiaryrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;

    }
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return user1;
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return updatedUser;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        User user = userService.findById(id);
        return user;
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        User user = userService.findById(id);
        userService.deleteUser(user);

    }

    @PutMapping("/{id}")
    public User updateEntryId(@PathVariable("id")int id, @RequestBody User user){
        User user1 = userService.findById(id);// from db
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        User updatedUser=userService.updateUser(user1);
        return updatedUser;


    }



}
