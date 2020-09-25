package org.tec.ff4j.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(value = "ff4j.webconsole.secure", havingValue = "true", matchIfMissing = false)
@Slf4j
public class FF4jWebConsoleSecure extends WebSecurityConfigurerAdapter {

    @Value("${ff4j.webconsole.url:/ff4j-web-console}")
    private String webConsoleUrl;

    @Resource
    DataSource dataSource;

    @Resource
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Securing the webconsole access as property 'ff4j.webconsole.secure' is true");

        http.cors().and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(webConsoleUrl + "/**").hasRole("ADMIN")
                .and()
                .formLogin();
    }
}