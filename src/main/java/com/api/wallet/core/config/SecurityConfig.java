package com.api.wallet.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        final String[] SWAGGER_WHITELIST = {
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html"
        };

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(authorize -> authorize

                    .requestMatchers("/api/**").permitAll()
                    .requestMatchers(SWAGGER_WHITELIST).permitAll()

                    .anyRequest().authenticated()
            );

        return http.build();
    }
}
