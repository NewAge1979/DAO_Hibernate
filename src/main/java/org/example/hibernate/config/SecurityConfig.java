package org.example.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(
                        (request) -> {
                            request
                                    .requestMatchers("/persons", "/persons/index.html", "/persons/by-city").permitAll()
                                    .requestMatchers("/persons/by-age").hasRole("AGE")
                                    .requestMatchers("/persons/by-name-surname").hasRole("NAME")
                                    .anyRequest().authenticated();
                        }
                ).formLogin();
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Configuration
    public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("test1")
                    .password(passwordEncoder().encode("test1"))
                    .roles("AGE")
                    .and()
                    .withUser("test2")
                    .password(passwordEncoder().encode("test2"))
                    .roles("NAME");
        }
    }
}