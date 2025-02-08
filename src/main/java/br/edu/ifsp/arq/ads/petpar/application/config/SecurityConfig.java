package br.edu.ifsp.arq.ads.petpar.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for API requests
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/user/login", "/v1/user").permitAll()  // Allow login & user registration
                        .anyRequest().authenticated()  // Secure all other endpoints
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // No session management
                .formLogin(form -> form.disable())  // Prevents Spring Security from handling /login automatically
                .logout(logout -> logout.disable()); // Prevents automatic redirection after logout

        return http.build();
    }
}
