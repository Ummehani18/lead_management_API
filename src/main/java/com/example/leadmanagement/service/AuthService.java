package com.example.leadmanagement.service;

import com.example.leadmanagement.dto.LoginRequest;
import com.example.leadmanagement.dto.LoginResponse;
import com.example.leadmanagement.security.CustomUserDetailsService;
import com.example.leadmanagement.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;

    public AuthService(
            AuthenticationManager authenticationManager,
            CustomUserDetailsService customUserDetailsService,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                request.getUsername()
        );
        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(token);
    }

}
