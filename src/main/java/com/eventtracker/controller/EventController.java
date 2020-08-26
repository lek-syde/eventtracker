package com.eventtracker.controller;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eventtracker.model.Actor;
import com.eventtracker.model.Event;
import com.eventtracker.model.Repository;
import com.eventtracker.service.ActorService;
import com.eventtracker.service.EventService;
import com.eventtracker.service.RepoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class EventController {
	
	@Autowired
	EventService eventservice;
	
	@Autowired
	ActorService actorservice;
	
	@Autowired
	RepoService reposervice;
	
	
	@RequestMapping(value = "/")
	   public String baseurl() {
		
		System.out.println("entered");
		return "index";
		
	}
	
	//show all events
	@RequestMapping(value = "/events")
	   public List<Event> findAllEvents() {
		System.out.println("finding all events");
		
		return eventservice.findAll();
		
	}
	
	
	//show all events
	@RequestMapping(value = "/erase")
	   public ResponseEntity<?> deleteALL() {
		System.out.println("deleting all events");
		
		eventservice.deleteAll();
		
		return new ResponseEntity<String>("All Events Deleted",
                HttpStatus.OK);
		
	}
	
	
	//creating events
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	   public ResponseEntity<?>  createEvent( @RequestBody Event eventRequest ) {
		
		Event newEvent= new Event();
		
		
		if(eventservice.existsByEventid(eventRequest.getId())) {
			return new ResponseEntity<String>("Event Already Exists",
	                HttpStatus.BAD_REQUEST);
		}
		
		
		Actor newActor= new Actor();
		newActor.setId(eventRequest.getActor().getId());
		newActor.setLogin(eventRequest.getActor().getLogin());
		newActor.setAvatar_url(eventRequest.getActor().getAvatar_url());
		actorservice.createUpdateActor(newActor);
		
		
		Repository newRepository= new Repository();
		newRepository.setId(eventRequest.getRepo().getId());
		newRepository.setName(eventRequest.getRepo().getName());
		newRepository.setUrl(eventRequest.getRepo().getUrl());
		
		reposervice.createRepository(newRepository);
		
		newEvent.setActor(newActor);
		newEvent.setId(eventRequest.getId());
		newEvent.setType(eventRequest.getType());
		newEvent.setRepo(newRepository);
		newEvent.setCreated_at(eventRequest.getCreated_at());
		
		eventservice.createevent(newEvent);
		
		return new ResponseEntity<String>("Event successfully created",
                HttpStatus.CREATED);
		
		
		
	}
	
	
	//returning by actorid
		@RequestMapping(value = "/events/actors/{actorid}")
		   public ResponseEntity<?>  findAllEvents(@PathVariable("actorid") Long actorid) {
			
			if(actorservice.existsByActorId(actorid)) {
				return new ResponseEntity<Actor>(actorservice.findByActorId(actorid),
		                HttpStatus.OK);
			}
			
			return new ResponseEntity<String>("Actor not found",
	                HttpStatus.NOT_FOUND);
			
		}
		
		
		
		
		
		
		
		//updating actor id
		@PutMapping("/actors")
		  public ResponseEntity<?> updateUser( @RequestBody Actor actor) {

			if(actorservice.existsByActorId(actor.getId())) {
				Actor existingActor= actorservice.findByActorId(actor.getId());
				existingActor.setAvatar_url(actor.getAvatar_url());
				
				actorservice.createUpdateActor(existingActor);
				
				return new ResponseEntity<String>("Actor successfully updated",
		                HttpStatus.OK);
			}
			
		
		
		return new ResponseEntity<String>("Actor does not exist",
                HttpStatus.NOT_FOUND);
		  }

		
		
		
		
		//show all actors bby number of events
		@RequestMapping(value = "/actors")
		   public List<Actor> findAllActors() {
			System.out.println("finding all actors");
			List<Long> count = eventservice.findallEventsSortedByNumberActor();
			List<Actor> allactors= new ArrayList<>();
			
			
			for(int i=0; i<count.size(); i++) {
				allactors.add(actorservice.findByActorId(count.get(i)));
				
			 }
			
		    return	allactors;
			
			
		}
		
		
}
