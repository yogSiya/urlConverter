package com.example.urlConverter.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.urlConverter.model.UrlMapper;

public interface UrlMapperRepository extends JpaRepository<UrlMapper, Long> {
	List<UrlMapper> findAll();
	//for fetching actual url using short url
	@Query("select urlmapper from UrlMapper urlmapper where urlmapper.mapShortUrl =?1")
	Optional<UrlMapper> findByshortURL(String mapShortUrl);
}

