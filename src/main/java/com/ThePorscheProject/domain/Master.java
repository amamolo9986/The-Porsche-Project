package com.ThePorscheProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "master")
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String seriesName;
	private String seriesCategory;
	private String model;
	private Integer startYear;
	private Integer endYear;
	@Column(length = 1500)
	private String description;
	private String photo;
	private String label;

	public Master() {

	}

	public Master(Integer id, String seriesName, String seriesCategory, String model, Integer startYear,
			Integer endYear, String description, String photo, String label) {
		super();
		this.id = id;
		this.seriesName = seriesName;
		this.seriesCategory = seriesCategory;
		this.model = model;
		this.startYear = startYear;
		this.endYear = endYear;
		this.description = description;
		this.photo = photo;
		this.label = label;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
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

	public String getLabel() {
		return label;
	}

	public void setLabels(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Master [id=" + id + ", seriesName=" + seriesName + ", seriesCategory=" + seriesCategory + ", model="
				+ model + ", startYear=" + startYear + ", endYear=" + endYear + ", description=" + description
				+ ", photo=" + photo + ", label=" + label + "]";
	}
	
}
