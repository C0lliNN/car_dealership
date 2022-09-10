package com.raphael.cardealership.infrastructure.config;

import com.raphael.cardealership.infrastructure.controller.filter.FilterChainExceptionHandler;
import com.raphael.cardealership.infrastructure.controller.filter.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@EnableWebSecurity
@AllArgsConstructor
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JWTAuthorizationFilter authorizationFilter;
    private final FilterChainExceptionHandler filterChainExceptionHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(filterChainExceptionHandler, LogoutFilter.class)
                .addFilterAfter(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**", "/docs/**", "/swagger-ui/**", "/auth/**", "/participant/**").permitAll()
                .anyRequest().authenticated();
    }
}
