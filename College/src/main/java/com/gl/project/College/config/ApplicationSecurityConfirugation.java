package com.gl.project.College.config;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.project.College.service.DomainUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationSecurityConfirugation extends WebSecurityConfigurerAdapter {
	
	private final DomainUserDetailsService userDetailsService;

	// authentication

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		         //configure users
		         authenticationManagerBuilder
		                 .userDetailsService(this.userDetailsService)
		                 .passwordEncoder(passwordEncoder());
		    

	}

	// authorisation
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// configure authorization rules here
		httpSecurity.cors().disable();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity
                .authorizeRequests()
                	.antMatchers(GET,"/College/students/**")
                		.hasAnyRole("USER", "ADMIN")
                	//.permitAll()
                .antMatchers("/h2-console/**", "/login**", "/contact-us**")
                 	.permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/College/students/**")
                	.hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/College/students/**")
                	.hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/College/students/**")
                	.hasRole("MANAGER")
                .anyRequest()
                	.authenticated()
                .and()
                	.formLogin()
                .and()
                	.httpBasic()
               .and()
        	   .sessionManagement().sessionCreationPolicy(STATELESS);

		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
