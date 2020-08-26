package com.eventtracker.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	
	String type;
	
	
	@OneToOne(cascade =  CascadeType.ALL,
    		fetch = FetchType.LAZY)
	Actor actor;
	
	
	
	@OneToOne(cascade =  CascadeType.ALL,
    		fetch = FetchType.LAZY)
	Repository repo;


	

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
     Date created_at;
	
	
	


	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Actor getActor() {
		return actor;
	}




	public void setActor(Actor actor) {
		this.actor = actor;
	}




	public Repository getRepo() {
		return repo;
	}




	public void setRepo(Repository repo) {
		this.repo = repo;
	}




	public Date getCreated_at() {
		return created_at;
	}




	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
	
	

}
