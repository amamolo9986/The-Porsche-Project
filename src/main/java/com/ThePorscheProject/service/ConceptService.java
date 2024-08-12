package com.ThePorscheProject.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ThePorscheProject.domain.Master;
import com.ThePorscheProject.repository.MasterRepository;

@Service
public class ConceptService {
	
	private MasterRepository masterRepo;

	public ConceptService(MasterRepository masterRepo) {
		super();
		this.masterRepo = masterRepo;
	}

	public List<Master> findByLabel(String label) {
		if("Notable Concepts".equals(label)) {
			return masterRepo.findByLabel(label);
		}
		return Collections.emptyList();
	}

}
