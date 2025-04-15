package com.example.demo.service.impl;

import com.example.demo.entity.UserClass;
import com.example.demo.repository.UserRepositoryInt;
import com.example.demo.service.UserServiceInt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceIntImpl implements UserServiceInt {

    private final UserRepositoryInt repository;

    @Override
    public List<UserClass> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<UserClass> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserClass createUser(UserClass user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
