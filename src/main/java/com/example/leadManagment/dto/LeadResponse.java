package com.example.leadManagment.dto;

import com.example.leadManagment.enums.LeadStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeadResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String company;
    private LeadStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
