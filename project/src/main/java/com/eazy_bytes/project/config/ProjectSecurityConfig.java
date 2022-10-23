package com.eazy_bytes.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

//	@Autowired
//	private JwtTokenGenFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests()
		.antMatchers("/myAccount","/myLoans","/myCards","/myBalance").authenticated()
		.antMatchers("/contacts","/register").permitAll()
				.and().formLogin().and().httpBasic();

//		http.csrf().disable()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//		.authorizeRequests()
//			.antMatchers("/bank/account").authenticated()
//			.antMatchers("/contact").permitAll().and().formLogin()
//				.and().httpBasic();
//		
//		http.addFilterAfter(jwtFilter, BasicAuthenticationFilter.class)
//		.addFilterBefore(new JWTTokenValidationFilter(),BasicAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
//	@Bean
//	public UserDetailsService getUsersData(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}

//	@Bean
//	public UserDetailsService users() {
//		UserDetails jaid = User.builder().username("jaid").password(password.encode("password"))
//				//.roles(ApplicationUserRole.ADMIN.name())
//				.authorities("admin")//ApplicationUserRole.ADMIN.getGrantedAuthorirty())
//				.build();
//
//		UserDetails kuila = User.builder().username("kuila").password(password.encode("password"))
//				//.roles(ApplicationUserRole.STUDENT.name())
//				.authorities("read")//ApplicationUserRole.STUDENT.getGrantedAuthorirty())
//				.build();
//
//		UserDetails shankha = User.builder().username("shankha").password(password.encode("password"))
//				//.roles(ApplicationUserRole.ADMINTRAINEE.name())
//				.authorities("read")//ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorirty())
//				.build();
//
//		return new InMemoryUserDetailsManager(jaid, kuila, shankha);
//	}

}
