package com.example.leadmanagement.service;

import com.example.leadmanagement.dto.LeadRequest;
import com.example.leadmanagement.dto.LeadResponse;
import com.example.leadmanagement.dto.PageResponse;
import com.example.leadmanagement.entity.Lead;
import com.example.leadmanagement.mapper.LeadMapper;
import com.example.leadmanagement.repository.LeadRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper;
    private static final String LEAD_NOT_FOUND = "Lead not found with id: ";

    public LeadService(
            LeadRepository leadRepository,
            LeadMapper leadMapper) {

        this.leadRepository = leadRepository;
        this.leadMapper = leadMapper;
    }

    // Create Lead
    public LeadResponse createLead(LeadRequest leadRequest) {

        Lead lead = leadMapper.toEntity(leadRequest);

        Lead savedLead = leadRepository.save(lead);

        return leadMapper.toResponse(savedLead);
    }

    // Get All Leads
    public PageResponse<LeadResponse> getAllLeads(Pageable pageable) {

        Page<Lead> leadPage = leadRepository.findAll(pageable);

        PageResponse<LeadResponse> response = new PageResponse<>();

        response.setContent(
                leadPage.getContent()
                        .stream()
                        .map(leadMapper::toResponse)
                        .toList()
        );

        response.setPage(leadPage.getNumber());
        response.setSize(leadPage.getSize());
        response.setTotalElements(leadPage.getTotalElements());
        response.setTotalPages(leadPage.getTotalPages());

        return response;
    }

    public List<LeadResponse> searchLeads(String keyword) {

        return leadRepository
                .findByNameContainingIgnoreCaseOrPhoneContaining(
                        keyword,
                        keyword
                )
                .stream()
                .map(leadMapper::toResponse)
                .toList();
    }

    // Get Lead By Id
    public LeadResponse getLeadById(Long id) {

        Lead lead = findLeadById(id);

        return leadMapper.toResponse(lead);
    }

    // Update Lead
    public LeadResponse updateLead(Long id, LeadRequest request) {

        Lead lead = findLeadById(id);

        leadMapper.updateEntity(request, lead);

        Lead updatedLead = leadRepository.save(lead);

        return leadMapper.toResponse(updatedLead);
    }

    // Delete Lead
    public void deleteLead(Long id) {

        Lead lead = findLeadById(id);
        leadRepository.delete(lead);
    }

    private Lead findLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(LEAD_NOT_FOUND + id));
    }
}