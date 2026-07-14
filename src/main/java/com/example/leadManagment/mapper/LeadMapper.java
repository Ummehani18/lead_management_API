package com.example.leadManagment.mapper;

import com.example.leadManagment.dto.LeadRequest;
import com.example.leadManagment.dto.LeadResponse;
import com.example.leadManagment.entity.Lead;
import org.springframework.stereotype.Component;

@Component
public class LeadMapper {

    // DTO -> Entity
    public Lead toEntity(LeadRequest request) {

        Lead lead = new Lead();

        lead.setName(request.getName());
        lead.setPhone(request.getPhone());
        lead.setEmail(request.getEmail());
        lead.setCompany(request.getCompany());
        lead.setStatus(request.getStatus());

        return lead;
    }

    // Entity -> DTO
    public LeadResponse toResponse(Lead lead) {

        LeadResponse response = new LeadResponse();

        response.setId(lead.getId());
        response.setName(lead.getName());
        response.setPhone(lead.getPhone());
        response.setEmail(lead.getEmail());
        response.setCompany(lead.getCompany());
        response.setStatus(lead.getStatus());
        response.setCreatedAt(lead.getCreatedAt());
        response.setUpdatedAt(lead.getUpdatedAt());

        return response;
    }

    // Update existing entity
    public void updateEntity(LeadRequest request, Lead lead) {

        lead.setName(request.getName());
        lead.setPhone(request.getPhone());
        lead.setEmail(request.getEmail());
        lead.setCompany(request.getCompany());
        lead.setStatus(request.getStatus());
    }
}