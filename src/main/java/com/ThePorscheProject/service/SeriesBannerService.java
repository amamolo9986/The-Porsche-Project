package com.ThePorscheProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ThePorscheProject.domain.SeriesBanner;
import com.ThePorscheProject.repository.SeriesBannerRepository;

@Service
public class SeriesBannerService {
	
	private SeriesBannerRepository seriesBannerRepo;

	public SeriesBannerService(SeriesBannerRepository seriesBannerRepo) {
		super();
		this.seriesBannerRepo = seriesBannerRepo;
	}

	public SeriesBanner findBySeriesName(String seriesName) {
		Optional<SeriesBanner> seriesOpt = seriesBannerRepo.findBySeriesName(seriesName);
		return seriesOpt.orElse(null);
	}

	public List<SeriesBanner> getAllSeriesBanners() {
		return seriesBannerRepo.findAll();
	}

	

}
