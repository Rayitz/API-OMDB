package com.raymundo.gonet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the raymundo_gonet_omdb_rating database table.
 * 
 */
@Entity
@Table(name="raymundo_gonet_omdb_user")
@NamedQuery(name="RaymundoGonetOmbdUser.findAll", query="SELECT u FROM RaymundoGonetOmbdUser u")
public class RaymundoGonetOmbdUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="i_user")
	private int iUser;
   

	@Column(name="n_user")
	private String nUser;
	
	@Column(name="username", nullable = false, unique = true)
	private String username;

	@Column(name="password")
	private String password;

	public RaymundoGonetOmbdUser() {
	}

	public int getiUser() {
		return iUser;
	}

	public void setiUser(int iUser) {
		this.iUser = iUser;
	}

	public String getnUser() {
		return nUser;
	}

	public void setnUser(String nUser) {
		this.nUser = nUser;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	

}