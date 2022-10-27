package com.token.tolken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		return "Inside-Get.";
	}
	
	@PostMapping("/test1")
	public String test1() {
		return "Inside Post.";
	}
	
}
