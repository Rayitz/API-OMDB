package com.raymundo.gonet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.raymundo.gonet.service.OmdbapiService;

@RequestMapping("/omdb")
@RestController
public class OmdbapiController {

	
	@Autowired
	private OmdbapiService omdb;

    @RequestMapping("/getMovieByName")
    public String getMovieByName(@RequestParam String name) {
    	
    	String dataMovie = null;
    	
    	dataMovie = omdb.getByName(name);
    	
        return dataMovie;
    }
    
    @RequestMapping("/getMovieById")
    public JsonNode getMovieById(@RequestParam String id) {
  	
  	JsonNode dataMovie = null;
  	
  	dataMovie = omdb.getById(id);
  	
      return dataMovie;
  }
    
    
}
