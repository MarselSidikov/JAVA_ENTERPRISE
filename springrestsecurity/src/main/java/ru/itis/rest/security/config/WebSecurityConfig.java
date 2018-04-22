package ru.itis.rest.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.rest.security.filters.TokenAuthFilter;
import ru.itis.rest.security.manager.TokenAuthManager;

/**
 * 02.08.2017
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version 1.0
 */
@ComponentScan("ru.itis")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthFilter tokenAuthFilter;

    @Autowired
    private TokenAuthManager tokenAuthManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(tokenAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/rest/user/**").hasAuthority("USER")
                .antMatchers("/rest/admin/**").hasAuthority("ADMIN")
                .antMatchers("/login").permitAll();
        http.csrf().disable();
    }

    @Bean
    public TokenAuthFilter filter() {
        tokenAuthFilter.setAuthenticationManager(tokenAuthManager);
        return tokenAuthFilter;
    }

}
