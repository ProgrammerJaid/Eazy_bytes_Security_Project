package com.eazy_bytes.project.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.repo.CustomerRepo;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepo cRepo;

	@PostMapping("/user")
	public Customer getUserDetailsAfterLogin(@RequestBody Principal user) {
		List<Customer> customers = cRepo.findByEmail(user.getName());
		if (customers.size() > 0)
			return customers.get(0);
		else
			return null;
	}

}
