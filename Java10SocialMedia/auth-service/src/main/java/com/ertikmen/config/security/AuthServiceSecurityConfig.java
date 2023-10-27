package com.ertikmen.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class AuthServiceSecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;
    private static final String[] WHITELIST={
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api/v1/auth/register",
            "/api/v1/auth/login",
            "/api/v1/auth/activate_status",

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf().disable();

//        httpSecurity.authorizeRequests().antMatchers("/swagger-ui/**","v3/api-docs/**").permitAll().anyRequest().authenticated();
//        httpSecurity.authorizeRequests().antMatchers("/swagger-ui/**","v3/api-docs/**").authenticated().anyRequest().permitAll();

        httpSecurity.authorizeRequests().antMatchers(WHITELIST).permitAll().anyRequest().authenticated();
//        httpSecurity.authorizeRequests().antMatchers("/find_all").hasAuthority("ADMIN"); şeklinde de yetkilendirme verebiliriz.


       httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);


                return httpSecurity.build();
    }

}
