package com.example.leadManagment.controller;

import com.example.leadManagment.dto.LeadRequest;
import com.example.leadManagment.dto.LeadResponse;
import com.example.leadManagment.service.LeadService;

import jakarta.validation.Valid;

import com.example.leadManagment.dto.PageResponse;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeadResponse createLead(
            @Valid @RequestBody LeadRequest request) {

        return leadService.createLead(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    public PageResponse<LeadResponse> getAllLeads(Pageable pageable) {

        return leadService.getAllLeads(pageable);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    @GetMapping("/search")
    public List<LeadResponse> searchLeads(
            @RequestParam String keyword) {

        return leadService.searchLeads(keyword);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    @GetMapping("/{id}")
    public LeadResponse getLeadById(
            @PathVariable Long id) {

        return leadService.getLeadById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public LeadResponse updateLead(
            @PathVariable Long id,
            @Valid @RequestBody LeadRequest request) {

        return leadService.updateLead(id, request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLead(@PathVariable Long id) {

        leadService.deleteLead(id);
    }

}