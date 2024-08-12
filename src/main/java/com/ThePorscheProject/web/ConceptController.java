package com.ThePorscheProject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ThePorscheProject.domain.Master;
import com.ThePorscheProject.service.ConceptService;

@Controller
public class ConceptController {
	
	private ConceptService conceptService;
	
	public ConceptController(ConceptService conceptService) {
		super();
		this.conceptService = conceptService;
	}

	@GetMapping("/concepts")
	public String getConcept(ModelMap model) {
		List<Master> masters = conceptService.findByLabel("Notable Concepts");
		model.put("masters", masters);
		return "concept";
	}


}
