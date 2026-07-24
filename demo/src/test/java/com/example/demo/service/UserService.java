package com.example.demo.service;
import com.example.demo.entity.user;
import com.example.demo.repository.userRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private userRepository repository;
    private PasswordEncoder encoder;
    
    public UserService(userRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    public user registerUser(user users)
    {
        users.setPassword(encoder.encode(users.getPassword()));
        return repository.save(users);
    }
}