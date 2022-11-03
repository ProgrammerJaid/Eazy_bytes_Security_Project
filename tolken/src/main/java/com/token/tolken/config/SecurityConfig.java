package com.token.tolken.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.token.tolken.filter.JwtTokenGenFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private PasswordEncoder pEncode;
	
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.addFilterAfter(new JwtTokenGenFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeHttpRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated().and().formLogin().and().httpBasic();
		
		
//		.and().authorizeHttpRequests().and().addFilterAfter(new JwtTokenGenFilter()
//				,UsernamePasswordAuthenticationFilter.class).formLogin().and().httpBasic();
//		.authenticated().and().addFilterAfter(new JwtTokenGenFilter(),
//				UsernamePasswordAuthenticationFilter.class)
//			.formLogin().and().httpBasic();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails jaid = User.builder().username("jaid")
				.password(pEncode.encode("password"))
				.authorities("user")
				.build();
		
		return new InMemoryUserDetailsManager(jaid);
	}
	
	
}
