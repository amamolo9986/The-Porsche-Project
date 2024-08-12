package com.ThePorscheProject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ThePorscheProject.domain.Master;
import com.ThePorscheProject.service.RacingService;

@Controller
public class RacingController {
	
	private RacingService racingService;
	
	public RacingController(RacingService racingService) {
		super();
		this.racingService = racingService;
	}

	@GetMapping("/racing")
	public String getRacing(ModelMap model) {
	    List<Master> masters = racingService.findByLabel("Racing Models");
		model.put("masters", masters);
		return "racing";
	}

}
