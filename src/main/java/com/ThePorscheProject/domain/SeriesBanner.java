package com.ThePorscheProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seriesBanner")
public class SeriesBanner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String seriesName;
	private String photo;
	
	public SeriesBanner() {
		
	}

	public SeriesBanner(Integer id, String seriesName, String photo) {
		super();
		this.id = id;
		this.seriesName = seriesName;
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "SeriesBanner [id=" + id + ", seriesName=" + seriesName + ", photo=" + photo + "]";
	}
	
}
