package com.example.urlConverter.controller;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlConverter.api.UrlConvReqBody;
import com.example.urlConverter.model.UrlMapper;
import com.example.urlConverter.repo.UrlMapperRepository;
import com.example.urlConverter.repo.UrlMapperUtil;

@RestController
@RequestMapping(path = "/api/v1/urlparser")
public class UrlMapperController {
	private static final String SHORT_URL_CONST ="/";
	@Autowired
	private UrlMapperRepository urlMapperRepo;
	@Autowired
    private UrlMapperUtil mapputil; 
	LocalDateTime now = LocalDateTime.now();  
	



	//get short URL by passing actual url
	@PostMapping("/getshortUrl")
	public ResponseEntity<String> create(@Valid @RequestBody UrlConvReqBody urlRequest) {
		
			UrlMapper newUrlMapp = new UrlMapper();
			newUrlMapp.setActualUrl(urlRequest.getUrlString().trim());
			String shortUrl= SHORT_URL_CONST + mapputil.generateString(9);
			System.out.println("here1" + shortUrl);
			newUrlMapp.setMapShortUrl(shortUrl);
			newUrlMapp.setCreatedDt(now);
			urlMapperRepo.save(newUrlMapp);
	
		
		    return new ResponseEntity<>(shortUrl, HttpStatus.CREATED);
		
		
	}
	
	//get actual URL by passing short url
	@PostMapping("/getactualUrl")
	public ResponseEntity<String> fetchUrl(@Valid @RequestBody UrlConvReqBody urlRequest) {
		
		Optional<UrlMapper> urlMapp;
		urlMapp=urlMapperRepo.findByshortURL(urlRequest.getUrlString().trim());
		if (urlMapp.isPresent()) {
		 return new ResponseEntity<>(urlMapp.get().getActualUrl(), HttpStatus.OK);
		}else {
		return new ResponseEntity<>("no url exist for given short url", HttpStatus.NO_CONTENT);
		}
		
	}

}
