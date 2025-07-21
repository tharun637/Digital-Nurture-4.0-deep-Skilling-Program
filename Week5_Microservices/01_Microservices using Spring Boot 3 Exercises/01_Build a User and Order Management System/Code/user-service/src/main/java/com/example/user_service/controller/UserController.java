package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public String addUser(@RequestBody User user){
        return service.addUser(user);
    }
    @GetMapping
    public List<User> getAllUser(){
        return service.getAllUser();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return service.getUser(id);
    }
}
