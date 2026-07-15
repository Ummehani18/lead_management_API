package com.example.leadmanagement.dto;

import com.example.leadmanagement.enums.LeadStatus;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Data
@Schema(description = "Lead Response")
public class LeadResponse {
    @Schema(
            description = "Lead ID",
            example = "1"
    )
    private Long id;
    @Schema(
            description = "Lead Name",
            example = "Umme"
    )
    private String name;

    @Schema(
            description = "Phone Number",
            example = "9876543210"
    )
    private String phone;

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

    @Schema(
            description = "Lead Status",
            example = "NEW"
    )
    private LeadStatus status;

    @Schema(
            description = "Lead Creation Time"
    )
    private LocalDateTime createdAt;

    @Schema(
            description = "Lead Last Updated Time"
    )
    private LocalDateTime updatedAt;
}
