package com.eazy_bytes.project.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.repo.CustomerRepo;

@Service
public class EazyBankUserDetails implements UserDetailsService {

	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			List<Customer> collect = custRepo.findByEmail(username);
			List<GrantedAuthority> authorities = new ArrayList<>();
			if(collect.size()==0)
				throw new UsernameNotFoundException(username+" does not exists.");
			authorities.add(new SimpleGrantedAuthority(collect.get(0).getRole()));
			
		return new User(collect.get(0).getEmail(),collect.get(0).getPwd()
				,authorities);
	}

}
