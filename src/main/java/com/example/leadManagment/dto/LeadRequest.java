package com.example.leadManagment.dto;

import com.example.leadManagment.enums.LeadStatus;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class LeadRequest {
    private String name;
    private String phone;
    private String email;
    private String company;
    private LeadStatus status;

}
