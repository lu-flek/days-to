package ru.lubovflek.daysto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static ru.lubovflek.daysto.model.security.UserRole.ADMIN;
import static ru.lubovflek.daysto.model.security.UserRole.USER;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole(ADMIN.name())
                .antMatchers("/event/**").hasAnyRole(ADMIN.name(), USER.name())
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder().username("lu-flek").password(encodedPassword("lubapass")).roles(ADMIN.name()).build(),
                User.builder().username("yakovmike").password(encodedPassword("mikepass")).roles(ADMIN.name()).build(),
                User.builder().username("yakovivan").password(encodedPassword("ivanpass")).roles(USER.name()).build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    private String encodedPassword(String password) {
        return passwordEncoder().encode(password);
    }
}
