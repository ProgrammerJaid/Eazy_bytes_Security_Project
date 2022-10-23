package com.eazy_bytes.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.repo.CustomerRepo;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer c) {
		Customer savedCustomer = null;
        ResponseEntity<String> response = null;
        try {
        	String hashP = passEncoder.encode(c.getPwd());
        	c.setPwd(hashP);
            savedCustomer = repo.save(c);
            if (savedCustomer.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
		
	}
	
}
