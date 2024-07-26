package com.ThePorscheProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modelDescription")
public class ModelDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String seriesName;
	private String seriesCategory;
	@Column(length = 3000)
	private String description;
	private String photo;
	
	public ModelDescription() {
		
	}

	public ModelDescription(Integer id, String seriesName, String seriesCategory, String description, String photo) {
		super();
		this.id = id;
		this.seriesName = seriesName;
		this.seriesCategory = seriesCategory;
		this.description = description;
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

	public String getSeriesCategory() {
		return seriesCategory;
	}

	public void setSeriesCategory(String seriesCategory) {
		this.seriesCategory = seriesCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ModelDescription [id=" + id + ", seriesName=" + seriesName + ", seriesCategory=" + seriesCategory
				+ ", description=" + description + ", photo=" + photo + "]";
	}

}
