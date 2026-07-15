package com.example.leadmanagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LeadManagmentApplication {

    @Value("${local.server.port:${server.port:8080}}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(LeadManagmentApplication.class, args);
    }


    public enum Role {
        ADMIN,
        MEMBER
    }
}