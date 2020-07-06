package com.raymundo.gonet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the raymundo_gonet_omdb_rating database table.
 * 
 */
@Entity
@Table(name="raymundo_gonet_omdb_rating")
@NamedQuery(name="RaymundoGonetOmbdRating.findAll", query="SELECT r FROM RaymundoGonetOmbdRating r")
public class RaymundoGonetOmbdRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="i_rating_user")
	private int iRatingUser;
   
	@Id
	@Column(name="n_rating_movie_id")
	private String nRatingMovieId;
	
	@Column(name="q_rating")
	private int qRating;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="d_rating")
	private Date dRating;

	@Column(name="n_rating_comments")
	private String nRatingComents;

	public RaymundoGonetOmbdRating() {
	}

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

	public Date getdRating() {
		return dRating;
	}

	public void setdRating(Date dRating) {
		this.dRating = dRating;
	}

	public String getnRatingComents() {
		return nRatingComents;
	}

	public void setnRatingComents(String nRatingComents) {
		this.nRatingComents = nRatingComents;
	}

	
	

}