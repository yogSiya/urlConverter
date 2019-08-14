package com.example.urlConverter.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URL_MAPPING_TB")
public class UrlMapper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "ACT_URL_LONG")
	String actualUrl;

	@Column(name = "MAP_URL_SHORT")
	String mapShortUrl;

	@Column(name = "CREATED_DT")
	LocalDateTime createdDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActualUrl() {
		return actualUrl;
	}

	public void setActualUrl(String actualUrl) {
		this.actualUrl = actualUrl;
	}

	public String getMapShortUrl() {
		return mapShortUrl;
	}

	public void setMapShortUrl(String mapShortUrl) {
		this.mapShortUrl = mapShortUrl;
	}

	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
	
	
}
