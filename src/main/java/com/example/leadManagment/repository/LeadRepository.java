package com.example.leadManagment.repository;

import com.example.leadManagment.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    List<Lead> findByNameContainingIgnoreCaseOrPhoneContaining(
            String name,
            String phone
    );

}
