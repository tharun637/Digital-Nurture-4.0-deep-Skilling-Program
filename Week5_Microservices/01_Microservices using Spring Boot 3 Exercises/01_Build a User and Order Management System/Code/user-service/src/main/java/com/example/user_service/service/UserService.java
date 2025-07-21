package com.example.user_service.service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public String addUser(User user) {
        repo.save(user);
        return "User Added";
    }

    public List<User> getAllUser() {
       return repo.findAll();
    }

    public User getUser(int id) {
        return repo.findById(id).orElse(null);
    }
}
