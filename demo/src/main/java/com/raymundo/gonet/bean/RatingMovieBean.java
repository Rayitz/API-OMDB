package com.raymundo.gonet.bean;

/**
 * The persistent class for the hi_tra_acuse database table.
 * 
 */

public class RatingMovieBean{


	private int iRatingUser;
	private String nRatingMovieId;
	private int qRating;
	private String dRating;
	private String nRatingComents;
	private String nMovieTitle;
	private String nMoviePlot;
	private int qMovieYear;
	
	public int getiRatingUser() {
		return iRatingUser;
	}
	public void setiRatingUser(int iRatingUser) {
		this.iRatingUser = iRatingUser;
	}
	public String getnRatingMovieId() {
		return nRatingMovieId;
	}
	public void setnRatingMovieId(String nRatingMovieId) {
		this.nRatingMovieId = nRatingMovieId;
	}
	public int getqRating() {
		return qRating;
	}
	public void setqRating(int qRating) {
		this.qRating = qRating;
	}
	public String getdRating() {
		return dRating;
	}
	public void setdRating(String dRating) {
		this.dRating = dRating;
	}
	public String getnRatingComents() {
		return nRatingComents;
	}
	public void setnRatingComents(String nRatingComents) {
		this.nRatingComents = nRatingComents;
	}
	public String getnMovieTitle() {
		return nMovieTitle;
	}
	public void setnMovieTitle(String nMovieTitle) {
		this.nMovieTitle = nMovieTitle;
	}
	public String getnMoviePlot() {
		return nMoviePlot;
	}
	public void setnMoviePlot(String nMoviePlot) {
		this.nMoviePlot = nMoviePlot;
	}
	public int getqMovieYear() {
		return qMovieYear;
	}
	public void setqMovieYear(int qMovieYear) {
		this.qMovieYear = qMovieYear;
	}

	

}