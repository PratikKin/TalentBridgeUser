package com.TalentBridgeUser.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // new style
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // allow public register
                        .requestMatchers("/auth/**").permitAll() // allow public register
                        .anyRequest().authenticated() // others need authentication
                );

        return http.build();
    }
}
