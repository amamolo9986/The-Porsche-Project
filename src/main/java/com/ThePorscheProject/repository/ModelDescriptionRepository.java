package com.ThePorscheProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ThePorscheProject.domain.ModelDescription;

public interface ModelDescriptionRepository extends JpaRepository<ModelDescription, Integer>{

	List<ModelDescription> findBySeriesName(String seriesName);

}
