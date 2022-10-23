package com.eazy_bytes.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/myAccount")
	public ResponseEntity<String> getMyAccount(){
		return new ResponseEntity<String>("secured and will be soon",HttpStatus.OK);
	}
	
}
