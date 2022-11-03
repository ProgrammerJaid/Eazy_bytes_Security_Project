package com.token.tolken.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Value("${app.jwt-secret}")
	private String k;
	
	@GetMapping("/test")
	public String test() {
		return "Inside-Get."+k;
	}
	
	@PostMapping("/test1")
	public String test1() {
		return "Inside Post.";
	}
	
}
