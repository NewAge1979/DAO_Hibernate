package org.example.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test1").password(passwordEncoder().encode("test1")).authorities("AGE")
                .and()
                .withUser("test2").password(passwordEncoder().encode("test2")).authorities("NAME");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and().authorizeRequests().antMatchers("/persons", "/persons/index.html").permitAll()
                .and().authorizeRequests().antMatchers("/persons/all").permitAll()
                .and().authorizeRequests().antMatchers("/persons/by-age").hasAuthority("AGE")
                .and().authorizeRequests().antMatchers("/persons/by-name-surname").hasAuthority("NAME")
                .and().authorizeRequests().anyRequest().authenticated();
    }
}