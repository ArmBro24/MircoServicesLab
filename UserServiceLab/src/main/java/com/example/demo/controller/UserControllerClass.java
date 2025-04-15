package com.example.demo.controller;

import com.example.demo.entity.UserClass;
import com.example.demo.service.UserServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerClass {

    private final UserServiceInt userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserClass user) {
        UserClass createdUser = userService.createUser(user);

        if (createdUser != null) {
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.badRequest().body("❌ Failed to create user.");
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<UserClass> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return ResponseEntity.badRequest().body("⚠ No users found.");
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("❌ User not found."));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("✅ User deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("❌ Could not delete user.");
        }
    }
}
