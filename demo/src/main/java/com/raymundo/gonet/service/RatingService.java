package com.raymundo.gonet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.raymundo.gonet.api.RatingRepository;
import com.raymundo.gonet.bean.MessageBean;
import com.raymundo.gonet.bean.RatingMovieBean;
import com.raymundo.gonet.model.RaymundoGonetOmbdRating;
import com.raymundo.gonet.utilities.Constant;
import com.raymundo.gonet.utilities.Utilities;

@Service
public class RatingService {

	
	@Autowired
	private RatingRepository rRating;

	@Autowired
	private OmdbapiService sOmdb;

	@SuppressWarnings("unused")
	@Transactional
	public String setRating(JsonNode dataMovie, int idUser, String idMovie, int rating, String date, String comments,
			int execute) {
		MessageBean messageBean = null;
		 
		if (dataMovie == null || dataMovie.get("imdbID") == null || dataMovie.get("imdbID").asText().isEmpty()) {
			
			messageBean = new MessageBean();
			messageBean.setMessage( Constant.NO_MOVIE_ID+ idMovie );
			String message = Utilities.mensajeToJson(messageBean);
			return message;
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dDate = null;
			try {
				dDate = formatter.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RaymundoGonetOmbdRating eRating = new RaymundoGonetOmbdRating();
			eRating.setiRatingUser(idUser);
			eRating.setnRatingMovieId(idMovie);
			eRating.setdRating(dDate);
			eRating.setqRating(rating);
			eRating.setnRatingComents(comments);
			if (execute == Constant.PERSIST) {
				eRating = rRating.setRating(eRating);
			} else {
				eRating = rRating.updateRating(eRating);
			}
			messageBean = new MessageBean();
			messageBean.setMessage( Constant.RATING_OK );
			String message = Utilities.mensajeToJson(messageBean);
			return message;
		}
	}

	@SuppressWarnings("unused")
	@Transactional
	public String getRatings(int idUser) {

		List<RatingMovieBean> beanList = new ArrayList<RatingMovieBean>();
		List<RaymundoGonetOmbdRating> listRatings = rRating.getRatings(idUser);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    	System.out.println("hola: "+listRatings.size());
		String sDate = null;
		JsonNode dataOmdb = null;
		String finalJson = null;
		for (RaymundoGonetOmbdRating entity : listRatings) {
			System.out.println("id: " + entity.getnRatingMovieId());
			RatingMovieBean bean = new RatingMovieBean();
			bean.setiRatingUser(entity.getiRatingUser());
			bean.setnRatingMovieId(entity.getnRatingMovieId());
			bean.setnRatingComents(entity.getnRatingComents());
			sDate = formatter.format(entity.getdRating());
			bean.setdRating(sDate);
			bean.setqRating(entity.getqRating());
			dataOmdb = sOmdb.getById(entity.getnRatingMovieId());
			if (dataOmdb != null) {
				bean.setnMovieTitle(dataOmdb.get("Title").asText());
				bean.setqMovieYear(Integer.parseInt(dataOmdb.get("Year").asText()));
				bean.setnMoviePlot(dataOmdb.get("Plot").asText());
			}
			beanList.add(bean);

		}

		if(listRatings.size()>0) {
			finalJson = Utilities.ratingListToJson(beanList);
		}else {
			MessageBean messageBean = new MessageBean();
			messageBean.setMessage( Constant.NO_RATING );
			finalJson = Utilities.mensajeToJson(messageBean);
		}
		

		return finalJson;
	}

	@SuppressWarnings("unused")
	@Transactional
	public String deleteRating(int idUser, String idMovie) {
		MessageBean messageBean = null;
		RaymundoGonetOmbdRating entity = rRating.getRatingsByUserMovie(idUser, idMovie);
		if(entity!=null){
		rRating.deleteRating(idUser, idMovie);
		}else{
			messageBean = new MessageBean();
			messageBean.setMessage( Constant.NOT_FOUND_RATING);
			String message = Utilities.mensajeToJson(messageBean);
			return message;
		}

		messageBean = new MessageBean();
		messageBean.setMessage( Constant.BYE_RATING );
		String message = Utilities.mensajeToJson(messageBean);
		
		return message;
	}

}


  
