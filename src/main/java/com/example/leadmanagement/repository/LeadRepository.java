package com.example.leadmanagement.repository;

import com.example.leadmanagement.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    List<Lead> findByNameContainingIgnoreCaseOrPhoneContaining(
            String name,
            String phone
    );

}
