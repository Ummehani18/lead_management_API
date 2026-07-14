package com.example.leadManagment.dto;

import com.example.leadManagment.enums.LeadStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data

public class LeadRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone is required")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "Phone must contain digits only"
    )
    @Size(
            min = 10,
            max = 10,
            message = "Phone must be exactly 10 digits"
    )
    private String phone;

    @Email(message = "Please enter valid email")
    private String email;

    private String company;

    @NotNull(message = "Status is required")
    private LeadStatus status;


}
