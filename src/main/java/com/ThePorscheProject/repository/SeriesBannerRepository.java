package com.ThePorscheProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ThePorscheProject.domain.SeriesBanner;

public interface SeriesBannerRepository extends JpaRepository<SeriesBanner, Integer>{

	Optional<SeriesBanner> findBySeriesName(String seriesName);



}
