package com.masai.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MasaiCabSecurityConfig {
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.csrf().disable()
		.authorizeHttpRequests(
				(auth) -> auth.antMatchers("/masaicab/driver/register").permitAll().antMatchers("/masaicab/user/register").permitAll()
				.antMatchers("/masaicab/user/login").permitAll()
				.antMatchers("/masaicab/**").authenticated()
				
		)
		.httpBasic();
		 
		return http.build();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}


}
