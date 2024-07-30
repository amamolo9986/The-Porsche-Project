package com.ThePorscheProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ThePorscheProject.domain.ModelDescription;
import com.ThePorscheProject.repository.ModelDescriptionRepository;

@Service
public class ModelDescriptionService {
	
	private ModelDescriptionRepository modelDescriptionRepo;

	public ModelDescriptionService(ModelDescriptionRepository modelDescriptionRepo) {
		super();
		this.modelDescriptionRepo = modelDescriptionRepo;
	}

	public List<ModelDescription> findModelDescriptionsBySeriesName(String seriesName) {
        return modelDescriptionRepo.findBySeriesName(seriesName);
    }

}
