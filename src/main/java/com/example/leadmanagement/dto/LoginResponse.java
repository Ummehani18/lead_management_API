package com.example.leadmanagement.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Login Response")
public class LoginResponse {
    @Schema(
            description = "JWT Authentication Token",
            example = "eyJhbGciOiJIUzI1NiJ9..."
    )
    private String token;

    public LoginResponse() {

    }

    public LoginResponse(String token) {

        this.token = token;
    }


}
