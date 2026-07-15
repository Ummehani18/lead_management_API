package com.example.leadmanagement.controller;

import com.example.leadmanagement.dto.LeadRequest;
import com.example.leadmanagement.dto.LeadResponse;
import com.example.leadmanagement.dto.PageResponse;
import com.example.leadmanagement.service.LeadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springdoc.core.annotations.ParameterObject;

import java.util.List;

@RestController
@RequestMapping("/leads")
@Tag(
        name = "Lead Management",
        description = "Lead CRUD APIs"
)
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create Lead",
            description = "Creates a new lead."
    )
    @ApiResponse(responseCode = "201", description = "Lead created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    public LeadResponse createLead(
            @Valid @RequestBody LeadRequest request) {

        return leadService.createLead(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    @Operation(
            summary = "Get All Leads",
            description = "Returns paginated list of leads."
    )
    @ApiResponse(responseCode = "200", description = "Leads retrieved successfully")
    public PageResponse<LeadResponse> getAllLeads(
            @ParameterObject Pageable pageable) {

        return leadService.getAllLeads(pageable);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    @GetMapping("/search")
    @Operation(
            summary = "Search Leads",
            description = "Search leads by name or phone."
    )
    @ApiResponse(responseCode = "200", description = "Search completed")
    public List<LeadResponse> searchLeads(
            @RequestParam String keyword) {

        return leadService.searchLeads(keyword);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Lead By ID",
            description = "Returns a lead by its ID."
    )
    @ApiResponse(responseCode = "200", description = "Lead found")
    @ApiResponse(responseCode = "404", description = "Lead not found")
    public LeadResponse getLeadById(
            @PathVariable Long id) {

        return leadService.getLeadById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @Operation(
            summary = "Update Lead",
            description = "Updates an existing lead."
    )
    @ApiResponse(responseCode = "200", description = "Lead updated successfully")
    @ApiResponse(responseCode = "404", description = "Lead not found")
    public LeadResponse updateLead(
            @PathVariable Long id,
            @Valid @RequestBody LeadRequest request) {

        return leadService.updateLead(id, request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete Lead",
            description = "Deletes a lead."
    )
    @ApiResponse(responseCode = "204", description = "Lead deleted successfully")
    @ApiResponse(responseCode = "404", description = "Lead not found")
    public void deleteLead(@PathVariable Long id) {

        leadService.deleteLead(id);
    }

}