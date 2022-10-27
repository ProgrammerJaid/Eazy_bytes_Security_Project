package com.eazy_bytes.project.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig {

//	@Autowired
//	private JwtTokenGenFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(3600L);
                return config;
            }
        }).and().csrf().ignoringAntMatchers("/notices","/contact")
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()). 
			and().authorizeHttpRequests()
                .antMatchers("/myAccount","/myCards").hasRole("USER")
                .antMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                .antMatchers("/myLoans").hasRole("ROOT")
                .antMatchers("/user").authenticated()
                .antMatchers("/notices", "/contact").permitAll()
				
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
