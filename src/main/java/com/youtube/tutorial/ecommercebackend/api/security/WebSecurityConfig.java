package com.youtube.tutorial.ecommercebackend.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration

public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .anyRequest().permitAll()
        )
        .csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable);
    return http.build();
  }

}
