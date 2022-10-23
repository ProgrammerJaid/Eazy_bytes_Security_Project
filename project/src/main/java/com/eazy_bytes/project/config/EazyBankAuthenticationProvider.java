package com.eazy_bytes.project.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.repo.CustomerRepo;

@Component
public class EazyBankAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private PasswordEncoder passEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<Customer> collect = custRepo.findByEmail(name);
		if (collect.size() == 0)
			throw new BadCredentialsException(name + " does not exists.");

		if (!passEncoder.matches(password, collect.get(0).getPwd()))
			throw new BadCredentialsException("Invalid Password.");

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(collect.get(0).getRole()));
		return new UsernamePasswordAuthenticationToken(name, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
