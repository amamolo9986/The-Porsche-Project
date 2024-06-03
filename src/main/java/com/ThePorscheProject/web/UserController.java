package com.ThePorscheProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("users/profile")
	public String getUserProfile (ModelMap model) {
		return "userProfile";
	}

}
