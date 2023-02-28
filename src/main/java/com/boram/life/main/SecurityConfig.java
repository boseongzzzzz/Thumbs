package com.boram.life.main;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain loginFilter(HttpSecurity http) throws Exception{
        return http.csrf().disable()
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin().defaultSuccessUrl("/index")
                    .and()
                .logout()
                .and()
                .build();

    }
}
