package com.ThePorscheProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ThePorscheProject.repository.SeriesBannerRepository;

@Service
public class SeriesBannerService {
	
	private SeriesBannerRepository seriesBannerRepository;

	public SeriesBannerService(SeriesBannerRepository seriesBannerRepository) {
		super();
		this.seriesBannerRepository = seriesBannerRepository;
	}


	public List<String> getAllPhotos() {
		return seriesBannerRepository.findAllPhotos();
	}

}
