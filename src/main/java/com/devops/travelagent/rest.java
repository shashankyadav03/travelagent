package com.devops.travelagent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class rest {   
	@GetMapping("/")    
	public String index()  {    
		return"index";    
	}    
	
	@GetMapping("/home")
	public String home(ModelMap model) {
		return "welcome";
	}
	
	@GetMapping("/agent")
	public String agent(ModelMap model) {
		return "agent";
	}
	
}
