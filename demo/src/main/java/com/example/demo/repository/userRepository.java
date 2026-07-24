package com.example.demo.repository;
import com.example.demo.entity.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface userRepository extends JpaRepository<user, Long>{
    Optional<user> findByEmail(String email);
}
