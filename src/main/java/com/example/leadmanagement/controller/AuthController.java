package com.example.leadmanagement.controller;

import com.example.leadmanagement.dto.LoginRequest;
import com.example.leadmanagement.dto.LoginResponse;
import com.example.leadmanagement.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/auth")
@Tag(
        name = "Authentication",
        description = "Authentication APIs"
)
public class AuthController {

    private final AuthService authService;



    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            summary = "Login User",
            description = "Authenticates the user and returns a JWT token."
    )
    @ApiResponse(responseCode = "200", description = "Login successful")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}