package com.example.demo.repository;

import com.example.demo.entity.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInt extends JpaRepository<UserClass, Long> {
    UserClass findTopByOrderByIdDesc();
}
