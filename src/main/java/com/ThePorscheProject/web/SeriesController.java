package com.ThePorscheProject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ThePorscheProject.domain.ModelDescription;
import com.ThePorscheProject.domain.SeriesBanner;
import com.ThePorscheProject.service.ModelDescriptionService;
import com.ThePorscheProject.service.SeriesBannerService;

@Controller
public class SeriesController {
	
	private SeriesBannerService seriesBannerService;
	private ModelDescriptionService modelDescriptionSerice;

	public SeriesController(SeriesBannerService seriesBannerService, ModelDescriptionService modelDescriptionSerice) {
		super();
		this.seriesBannerService = seriesBannerService;
		this.modelDescriptionSerice = modelDescriptionSerice;
	}

	@GetMapping("/series")
	public String getSeries(ModelMap model) {
		List<SeriesBanner> seriesBanners = seriesBannerService.getAllSeriesBanners();
		model.put("seriesBanners", seriesBanners);
		return "series";
	}
	
	@GetMapping("/series/{seriesName}")
	public String findBtSeriesName(ModelMap model, @PathVariable String seriesName) {
		SeriesBanner seriesBanner = seriesBannerService.findBySeriesName(seriesName);
		List<ModelDescription> categories = modelDescriptionSerice.findCategoriesBySeriesName(seriesName);
		model.put("seriesBanner", seriesBanner);
	    model.put("categories", categories);
		return "seriesCategory";
		}
		
}







