package com.example.leadManagment.repository;

import com.example.leadManagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
