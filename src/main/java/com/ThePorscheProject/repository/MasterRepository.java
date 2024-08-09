package com.ThePorscheProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ThePorscheProject.domain.Master;

public interface MasterRepository extends JpaRepository<Master, Integer>{

	List<Master> findBySeriesCategory(String seriesCategory);

	List<Master> findByLabel(String label);

}
