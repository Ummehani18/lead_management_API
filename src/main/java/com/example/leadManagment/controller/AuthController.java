package com.example.leadManagment.controller;

import com.example.leadManagment.dto.LoginRequest;
import com.example.leadManagment.dto.LoginResponse;
import com.example.leadManagment.service.AuthService;

import jakarta.validation.Valid;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {
        System.out.println("controller reached");
        return authService.login(request);
    }
}
