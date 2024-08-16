package com.ThePorscheProject.web;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ThePorscheProject.domain.Master;
import com.ThePorscheProject.domain.ModelDescription;
import com.ThePorscheProject.domain.SeriesBanner;
import com.ThePorscheProject.service.MasterService;
import com.ThePorscheProject.service.ModelDescriptionService;
import com.ThePorscheProject.service.SeriesBannerService;

@Controller
public class SeriesController {

	private SeriesBannerService seriesBannerService;
	private ModelDescriptionService modelDescriptionSerice;
	private MasterService masterService;

	public SeriesController(SeriesBannerService seriesBannerService, ModelDescriptionService modelDescriptionSerice,
			MasterService masterService) {
		super();
		this.seriesBannerService = seriesBannerService;
		this.modelDescriptionSerice = modelDescriptionSerice;
		this.masterService = masterService;
	}

	@GetMapping("/series")
	public String getSeriesBanners(ModelMap model) {
		List<SeriesBanner> seriesBanners = seriesBannerService.getAllSeriesBanners();
		model.put("seriesBanners", seriesBanners);
		return "series";
	}

	@GetMapping("/series/{seriesName}")
	public String findBySeriesName(ModelMap model, @PathVariable String seriesName) {
		SeriesBanner seriesBanner = seriesBannerService.findBySeriesName(seriesName);
		List<ModelDescription> modelDescriptions = modelDescriptionSerice.findModelDescriptionsBySeriesName(seriesName);
		model.put("seriesBanner", seriesBanner);
		model.put("modelDescriptions", modelDescriptions);
		return "seriesCategory";
	}

	@GetMapping("/series/{seriesName}/{seriesCategory}")
    public String findBySeriesCategory(ModelMap model, @PathVariable String seriesName, @PathVariable String seriesCategory) {
		List<Master> masters = masterService.findBySeriesCategory(seriesCategory);
		SeriesBanner seriesBanner = seriesBannerService.findBySeriesName(seriesName);
		model.put("masters", masters);
		model.put("seriesBanner", seriesBanner);
		model.put("seriesCategory", seriesCategory);
        return "seriesModel";
    }
}
