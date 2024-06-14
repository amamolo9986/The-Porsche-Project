package com.ThePorscheProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassicController {
	
	@GetMapping("/classics")
	public String getClassic() {
		return "classic";
	}

}
