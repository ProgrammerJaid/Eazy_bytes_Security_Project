package com.eazy_bytes.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class BalanceController {

	@GetMapping("/myBalance")
	public ResponseEntity<String> getMyAccount(){
		return new ResponseEntity<String>("secured and will be soon",HttpStatus.OK);
	}
	
}
