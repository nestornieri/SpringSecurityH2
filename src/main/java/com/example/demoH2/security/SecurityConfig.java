package com.example.demoH2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    // Configuración de la autenticación básica
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home").permitAll() // Permitir acceso sin autenticación a estas rutas
                        .requestMatchers("/listar_public").permitAll()
                        .requestMatchers("/listar_admin").hasRole("ADMIN")
                        .requestMatchers("/listar_user").hasRole("USER")

                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
                .httpBasic(httpBasic -> httpBasic
                        .realmName("Your Realm Name") // Opcional: Configurar un nombre de realm
                )
                .logout(logout -> logout.permitAll()); // Configuración de logout

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder() // Solo para pruebas
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        UserDetails admin =
                User.withDefaultPasswordEncoder() // Solo para pruebas
                        .username("admin")
                        .password("adminpassword")
                        .roles("ADMIN","USER")
                        .build();



        return new InMemoryUserDetailsManager(user, admin);
    }


}
