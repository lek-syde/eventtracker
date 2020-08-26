package com.eventtracker.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.eventtracker.model.Event;
import com.eventtracker.repository.EventRepo;
import com.eventtracker.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	
	@Autowired
	EventRepo eventRepo;
	

	@Override
	public void createevent(Event event) {
		eventRepo.save(event);
		
	}

	@Override
	public Event findByEventid(long eventid) {
		return eventRepo.findById(eventid).get();
	
	}

	@Override
	public List<Event> findAll() {
		
		return eventRepo.findAll(Sort.by("id").ascending());
	}

	@Override
	public boolean existsByEventid(long eventid) {
		return eventRepo.existsById(eventid);
	}

	@Override
	public void deleteAll() {
		
		eventRepo.deleteAll();
	}

	@Override
	public List<Long> findallEventsSortedByNumberActor() {
		return eventRepo.findallEventsSortedByNumberActor();
	}

}
