package com.A.UsuarioService.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no es necesario
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/user/login" , "/user/register").permitAll() // Permitir acceso público a /login
                        .anyRequest().authenticated() // Todas las demás solicitudes requieren autenticación
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login").permitAll()
                )
                .build();
    }
}