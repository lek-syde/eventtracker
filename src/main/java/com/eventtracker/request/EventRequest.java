package com.eventtracker.request;

import com.eventtracker.model.Actor;
import com.eventtracker.model.Repository;

public class EventRequest {
	String type;
	
	Actor actor;
	Repository repo;
	
	
	
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
	
	
	
	
}
