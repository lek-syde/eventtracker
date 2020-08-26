package com.eventtracker.service;

import java.util.List;

import com.eventtracker.model.Event;

public interface EventService {
	
		public abstract void createevent(Event event);
	   
	   public abstract Event findByEventid(long eventid);
	   
	   public abstract boolean  existsByEventid(long eventid);
	   public abstract List<Event> findAll();
	   
	   
	   public abstract void deleteAll();
	   
	   public abstract List<Long> findallEventsSortedByNumberActor();
	   
	   
}
