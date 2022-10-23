package com.eazy_bytes.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazy_bytes.project.model.Accounts;
import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.repo.AccountRepo;

@RestController
public class AccountController {

	@Autowired
	private AccountRepo accountsRepository;
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts accounts = accountsRepository.findByCustomerId(customer.getId());
		if (accounts != null )
			return accounts;
		else
			return null;
	}
	
}
