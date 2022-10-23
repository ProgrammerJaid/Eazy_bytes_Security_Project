package com.eazy_bytes.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	
	@GetMapping("/myLoan")
	public ResponseEntity<String> getMyAccountloan(){
		return new ResponseEntity<String>("secured and will be soon",HttpStatus.OK);
	}
}
