package com.example.demo5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class AuthConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager get() {
        UserDetails user = User.withUsername("test")
                .password(passwordEncoder().encode("test"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/students").hasAnyRole("USER")
                .antMatchers("/tasks").hasAnyRole("ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()//teraz konfigurujemy formularz autoryzacji
                .loginPage("/login")
                .usernameParameter("username") // nadajemy nazwę dla name w inpucie loginu formularza
                .passwordParameter("password") // nadajemy nazwę dla name w inpucie hasła formularza
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error") // co się stanie w momencie wpisania błędnych danych
                .defaultSuccessUrl("/") // co się stanie w momencie prawidłowego uwierzytelnienia
                .and()
                .logout()  //mówimy springowi, że przechodzimy do obsługi logout
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout");
        return http.build();
    }
}
