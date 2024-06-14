package com.ThePorscheProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RacingController {
	
	@GetMapping("/racing")
	public String getRacing() {
		return "racing";
	}

}
