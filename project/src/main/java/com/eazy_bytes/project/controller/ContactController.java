package com.eazy_bytes.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@RequestMapping("/contacts")
	public ResponseEntity<String> getMyAccount(){
		return new ResponseEntity<String>("Not Secured.",HttpStatus.OK);
	}
}
