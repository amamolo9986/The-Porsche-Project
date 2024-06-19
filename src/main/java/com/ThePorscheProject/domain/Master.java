package com.ThePorscheProject.domain;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "master")
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String seriesName;
	private String model;
	private Integer startYear;
	private Integer endYear;
	@Column(length = 1500)
	private String description;
	private String photo;
	
	@ElementCollection
	@CollectionTable(name = "porsche_categories", joinColumns = @JoinColumn(name = "porsche_id"))
	@Column(name = "category")
	private Set<String> categories;

	public Master() {

	}

	public Master(Integer id, String seriesName, String model, Integer startYear, Integer endYear, String description,
			String photo, Set<String> categories) {
		super();
		this.id = id;
		this.seriesName = seriesName;
		this.model = model;
		this.startYear = startYear;
		this.endYear = endYear;
		this.description = description;
		this.photo = photo;
		this.categories = categories;
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

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Master [id=" + id + ", seriesName=" + seriesName + ", model=" + model + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", description=" + description + ", photo=" + photo + ", categories="
				+ categories + "]";
	}
	
}
