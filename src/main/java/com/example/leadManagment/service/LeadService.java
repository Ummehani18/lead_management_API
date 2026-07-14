package com.example.leadManagment.service;

import com.example.leadManagment.dto.LeadRequest;
import com.example.leadManagment.dto.LeadResponse;
import com.example.leadManagment.entity.Lead;
import com.example.leadManagment.mapper.LeadMapper;
import com.example.leadManagment.repository.LeadRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.example.leadManagment.dto.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper;

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
                .collect(Collectors.toList());
    }

    // Get Lead By Id
    public LeadResponse getLeadById(Long id) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Lead not found with id: " + id));

        return leadMapper.toResponse(lead);
    }

    // Update Lead
    public LeadResponse updateLead(Long id, LeadRequest request) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Lead not found with id: " + id));

        leadMapper.updateEntity(request, lead);

        Lead updatedLead = leadRepository.save(lead);

        return leadMapper.toResponse(updatedLead);
    }

    // Delete Lead
    public void deleteLead(Long id) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Lead not found with id: " + id));

        leadRepository.delete(lead);
    }
}