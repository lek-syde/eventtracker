package com.eventtracker.service;

import java.util.List;


import com.eventtracker.model.Actor;


public interface ActorService {

	
	public abstract void createUpdateActor(Actor event);
	   
	public abstract Actor findByActorId(long actorid);
	
	public abstract boolean existsByActorId(long actorid);
	
	public abstract List<Actor> findAll();
}
