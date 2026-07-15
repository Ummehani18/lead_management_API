package com.example.leadmanagement.startup;

import com.example.leadmanagement.entity.User;
import com.example.leadmanagement.enums.Role;
import com.example.leadmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${app.default-admin.username}")
    private String adminUsername;

    @Value("${app.default-admin.password}")
    private String adminPassword;

    @Value("${app.default-member.username}")
    private String memberUsername;

    @Value("${app.default-member.password}")
    private String memberPassword;

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername(adminUsername).isEmpty()) {

            User admin = new User();
            admin.setUsername(adminUsername);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);
        }

        if (userRepository.findByUsername(memberUsername).isEmpty()) {

            User member = new User();
            member.setUsername(memberUsername);
            member.setPassword(passwordEncoder.encode(memberPassword));
            member.setRole(Role.MEMBER);

            userRepository.save(member);
        }
    }
}