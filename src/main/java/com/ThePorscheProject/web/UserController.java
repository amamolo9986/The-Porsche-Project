package com.ThePorscheProject.web;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ThePorscheProject.domain.User;
import com.ThePorscheProject.service.UserServiceImpl;

@Controller
public class UserController {
	
	private UserServiceImpl userServiceImpl;
	
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}

	@GetMapping("users/profile")
	public String getUserProfile (ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
	    Optional<User> userOpt = userServiceImpl.findUserByEmail(username); 
	    if (userOpt.isPresent()) {
	    	model.addAttribute("user", userOpt.get());
	    	System.out.println(userOpt);
	    }
		return "userProfile";
	}

}
