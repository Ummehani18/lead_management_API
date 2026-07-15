package com.example.leadmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Login Request")
public class LoginRequest {
    @NotBlank(message = "username is required")
    @Schema(
            description = "Username",
            example = "admin"
    )
    private String username;

    @NotBlank(message = "password is required")
    @Schema(
            description = "Password",
            example = "admin123"
    )
    private String password;
}
