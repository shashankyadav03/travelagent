package com.devops.travelagent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class rest {   
	@GetMapping("/")    
	public String index(Model model)  {  
		model.addAttribute("user", new user());
		return"index";    
	}    
	@PostMapping("welcome")//check
    public String personSubmit(@ModelAttribute user user,Model model) {
		System.out.println(user.username);
		model.addAttribute("search", new search());
		return "welcome";
//    return "results";
    }
	
	@PostMapping("agent")//check
    public String personSubmit(@ModelAttribute search search) {
		System.out.println(search.place);
		return "agent";
//    return "results";
    }
	
	
	
}
