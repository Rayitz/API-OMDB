package com.raymundo.gonet.controller;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.raymundo.gonet.bean.MessageBean;
import com.raymundo.gonet.service.OmdbapiService;
import com.raymundo.gonet.service.RatingService;
import com.raymundo.gonet.utilities.Constant;
import com.raymundo.gonet.utilities.Utilities;

@RequestMapping("/rating")
@RestController
public class RatingController {

	
	@Autowired
	private OmdbapiService omdb;
	
	@Autowired
	private RatingService sRating;
	
    
    @RequestMapping("/create")
    public String createRating(@RequestParam int idUser, @RequestParam String idMovie,@RequestParam int rating,@RequestParam String date,@RequestParam String comments) {
  	
    	JsonNode dataMovie = omdb.getById(idMovie);
    	String message = sRating.setRating(dataMovie,idUser,idMovie,rating,date,comments,Constant.PERSIST);

      return message;
  }
    
    @RequestMapping("/update")
    public String updateRating(@RequestParam int idUser, @RequestParam String idMovie,@RequestParam int rating,@RequestParam String date,@RequestParam String comments) {
  	
    	JsonNode dataMovie = omdb.getById(idMovie);
    	String message = sRating.setRating(dataMovie,idUser,idMovie,rating,date,comments,Constant.MERGE);

      return message;
  }
    
    @RequestMapping("/read")
    public String readRating(@RequestParam int idUser) {
  	
    	String ratings = sRating.getRatings(idUser);

      return ratings;
  }
    
    @RequestMapping("/delete")
    public String deleteRating(@RequestParam int idUser,@RequestParam String idMovie) {
  	
    	
    	String message = sRating.deleteRating(idUser,idMovie);

      return message;
  }
}
