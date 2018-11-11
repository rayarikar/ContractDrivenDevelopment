package com.rohan.development.contractdrivendevelopmentsample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        LOGGER.info("All endpoints secured with no authentication required.");
        httpSecurity.authorizeRequests().antMatchers("/*").permitAll();
        httpSecurity.csrf().disable();
    }
}
