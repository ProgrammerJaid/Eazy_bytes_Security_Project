package com.eazy_bytes.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

	@GetMapping("/notice")
	public ResponseEntity<String> getNotice(){
		return new ResponseEntity<String>("Not secured.", HttpStatus.OK);
	}
	
}
