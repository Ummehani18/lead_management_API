package com.example.leadmanagement.dto;

import com.example.leadmanagement.enums.LeadStatus;
import jakarta.validation.constraints.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Lead Creation Request")
public class LeadRequest {
    @NotBlank(message = "Name is required")
    @Schema(
            description = "Lead Name",
            example = "Umme"
    )
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
    @Schema(
            description = "Phone Number",
            example = "9876543210"
    )
    private String phone;

    @Email(message = "Please enter valid email")
    @Schema(
            description = "Email Address",
            example = "umme@gmail.com"
    )
    private String email;

    @Schema(
            description = "Company Name",
            example = "ABC Pvt Ltd"
    )
    private String company;

    @NotNull(message = "Status is required")
    @Schema(
            description = "Lead Status",
            example = "NEW"
    )
    private LeadStatus status;


}
