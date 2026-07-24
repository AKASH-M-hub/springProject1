package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.user;
import com.example.demo.service.JwtService;
import com.example.demo.service.userService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final userService service;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserController(userService service,
                          AuthenticationManager authenticationManager,
                          JwtService jwtService) {

        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // ==========================
    // Register User
    // ==========================
    @PostMapping("/register")
    public user registerUser(@RequestBody user users) {
        return service.registerUser(users);
    }

    // ==========================
    // Login User
    // ==========================
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        UserDetails userDetails =
                (UserDetails) authentication.getPrincipal();

        return jwtService.generateToken(userDetails);
    }
}