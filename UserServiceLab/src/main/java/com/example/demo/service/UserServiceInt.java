package com.example.demo.service;

import com.example.demo.entity.UserClass;

import java.util.List;
import java.util.Optional;

public interface UserServiceInt{
    List<UserClass> getAllUsers();
    Optional<UserClass> getUserById(Long id);
    UserClass createUser(UserClass user);
    void deleteUser(Long id);
}
