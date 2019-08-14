package com.example.urlConverter.api;

import javax.validation.constraints.NotNull;

public class UrlConvReqBody {
	   @NotNull 
	   private String urlString;

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
	   
	   
	   
}
