package com.ThePorscheProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConceptController {
	
	@GetMapping("/concepts")
	public String getConcept() {
		return "concept";
	}


}
