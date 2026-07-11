package com.example.leadManagment.dto;

import com.example.leadManagment.enums.LeadStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeadResponse {
    private String id;
    private String name;
    private String email;
    private String company;
    private LeadStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
