package com.eventtracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Actor {
	
	@Id
   long id;
	
	String login;
	String avatar_url;
	
	
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getAvatar_url() {
		return avatar_url;
	}


	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}


	


	
	
	
	

}
