package com.example.leadManagment.config;

import com.example.leadManagment.security.CustomUserDetailsService;
import com.example.leadManagment.security.JwtAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            CustomUserDetailsService userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception{
         return http.csrf(csrf->csrf.disable())
                 .authorizeHttpRequests(auth-> auth
                         .requestMatchers("/auth/**","/error")
                         .permitAll()
                         .anyRequest()
                         .authenticated()
                 )
                 .sessionManagement(session->
                         session.sessionCreationPolicy(
                                 SessionCreationPolicy.STATELESS
                         )
                 )
                 .exceptionHandling(exception -> exception
                         .authenticationEntryPoint(
                                 (request, response, authException) -> {
                                     response.sendError(
                                             HttpServletResponse.SC_UNAUTHORIZED,
                                             authException.getMessage()
                                     );
                                 }
                         )
                 )
                 .authenticationProvider(authenticationProvider())
                 .addFilterBefore(
                         jwtAuthenticationFilter,
                         UsernamePasswordAuthenticationFilter.class
                 ).build();

    }
}
