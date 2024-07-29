package com.ThePorscheProject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ThePorscheProject.service.SeriesBannerService;

@Controller
public class SeriesController {
	
	private SeriesBannerService seriesBannerService;
	

	public SeriesController(SeriesBannerService seriesBannerService) {
		super();
		this.seriesBannerService = seriesBannerService;
	}

	@GetMapping("/series")
	public String getSeries(ModelMap model) {
		List<String> photos = seriesBannerService.getAllPhotos();
		model.addAttribute("photos", photos);
		return "series";
	}
	
}
