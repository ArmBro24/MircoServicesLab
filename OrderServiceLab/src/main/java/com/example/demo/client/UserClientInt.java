package com.example.demo.client;


import com.example.demo.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserServiceLab")
public interface UserClientInt {
    @GetMapping("/api/v1/users/{id}")
    UserDTO getUserById(@PathVariable Long id);
}
