package com.devops.travelagent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to our Travel site!";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to our Travel site!";
	}
	
}
