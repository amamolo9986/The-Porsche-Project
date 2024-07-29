package com.ThePorscheProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ThePorscheProject.domain.SeriesBanner;

public interface SeriesBannerRepository extends JpaRepository<SeriesBanner, Integer>{

	@Query("select photo from SeriesBanner")
	List<String> findAllPhotos();

}
