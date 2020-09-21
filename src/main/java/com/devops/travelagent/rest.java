package com.devops.travelagent;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class rest {   
	
	userdb u1=new userdb();
	@GetMapping("/")    
	public String index(Model model)  {  
		model.addAttribute("user", new user());
		model.addAttribute("usersignup", new usersignup());
		
		u1.setuser("Kiran", "pass");
		u1.setuser("Shashank","pass");
		u1.setuser("Vivek", "pass");
		
		return"index";    
	}  
	
	@PostMapping("index")//check
    public String signup(@ModelAttribute usersignup usersignup ,Model model) {
		model.addAttribute("user", new user());
		model.addAttribute("usersignup", new usersignup());

		
		if(usersignup.password.equals(usersignup.rpassword)) {
			u1.setuser(usersignup.username, usersignup.password);
			return "index";
		}
		return "login-error";
    }
	
	@PostMapping("welcome")
    public String personSubmit(@ModelAttribute user user,Model model) {
		System.out.println(user.username);
		
		if(!u1.checkuser(user.username, user.password)) {
			model.addAttribute("user", new user());
			model.addAttribute("usersignup", new usersignup());
			return "login-error";
		}
		model.addAttribute("search", new search());
		model.addAttribute("user", user);
		
		return "welcome";
		

    }
	
	@PostMapping("agent")//check
    public String personSubmit(@ModelAttribute user user,@ModelAttribute search search,Model model) {
		System.out.println(search.place);
		if(search.place.length()<2) {
			model.addAttribute("search", new search());
			model.addAttribute("user", user);
			return "welcome";
		}
	
		model.addAttribute("search", search);
		return "agent";

    }
	
	
	
}
