package com.token.tolken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TolkenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TolkenApplication.class, args);
	}

	@Bean
	public PasswordEncoder pass() {
		return new PassEncode();
	}
	
}

class PassEncode implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.equals(encodedPassword);
	}
	
}

