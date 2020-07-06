package com.raymundo.gonet.api;

import java.util.List;

import com.raymundo.gonet.model.RaymundoGonetOmbdRating;

public interface RatingRepository {

	public List<RaymundoGonetOmbdRating> getRatings(int idUser);
	
	public RaymundoGonetOmbdRating setRating(RaymundoGonetOmbdRating rating);
	
	public RaymundoGonetOmbdRating updateRating(RaymundoGonetOmbdRating rating);
	
	public RaymundoGonetOmbdRating getRatingsByUserMovie(int idUser, String idMovie);
	
	public void deleteRating(int idUser, String idMovie);
}