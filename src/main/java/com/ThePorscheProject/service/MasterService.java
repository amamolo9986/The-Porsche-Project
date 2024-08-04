package com.ThePorscheProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ThePorscheProject.domain.Master;
import com.ThePorscheProject.repository.MasterRepository;

@Service
public class MasterService {

	private MasterRepository masterRepo;

	public MasterService(MasterRepository masterRepo) {
		super();
		this.masterRepo = masterRepo;
	}

	public List<Master> findBySeriesCategory(String seriesCategory) {
		return masterRepo.findBySeriesCategory(seriesCategory);
	}

	

}
